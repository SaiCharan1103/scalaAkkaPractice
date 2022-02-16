package Akka.Http

import akka.actor.typed.ActorSystem
import akka.actor.typed.javadsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpRequest, HttpResponse, Uri}
import scala.concurrent.ExecutionContext
import scala.io.StdIn

object HttpServerlowLevel {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem[Nothing] =ActorSystem(Behaviors.empty,"lowlevel")
    implicit val executionContext:ExecutionContext = system.executionContext

    val requestHandler:HttpRequest => HttpResponse ={
      case HttpRequest(GET,Uri.Path("/"),_,_,_) =>
        HttpResponse(entity = HttpEntity(
          ContentTypes.`text/html(UTF-8)`,"<html><body>Hello world!</body></html>"))
      case HttpRequest(GET,Uri.Path("/ping"),_,_,_) =>
        HttpResponse(entity = "PONG!")
      case HttpRequest(GET,Uri.Path("/crash"),_,_,_) =>
        sys.error("BOOM!")
      case r:HttpRequest =>
        r.discardEntityBytes()
        HttpResponse(404,entity = "Unknown resource!")
    }
    val bindingFuture = Http().newServerAt("localhost",8083).bindSync(requestHandler)
    println(s"Server online at http://localhost:8083/\n Press RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ =>system.terminate())
  }
}