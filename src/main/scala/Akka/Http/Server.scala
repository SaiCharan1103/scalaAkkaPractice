package Akka.Http


import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

import scala.concurrent.ExecutionContext

object Server extends App {
  val host = "0.0.0.0"
  val port = 9000
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty,"helloworld")
  implicit val executor: ExecutionContext = system.executionContext

//    implicit val materializer:ActorMaterializer = ActorMaterializer
  def route = path("hello") {
    get {
      complete("Hello, World!")
    }
  }
  Http().newServerAt(host, port).bind(route)
}
