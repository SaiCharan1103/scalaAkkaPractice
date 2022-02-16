package Akka.Http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{complete, path}
import scala.concurrent.ExecutionContext

object Server extends App {
  val host = "0.0.0.0"
  val port = 9000
  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcher

  //  implicit val materializer:ActorMaterializer = ActorMaterializer
//  def route = path("hello") {
//    get {
//      complete("Hello, World!")
//    }
//  }
//
//  Http().newServerAt(host, port).bind(route)
}
