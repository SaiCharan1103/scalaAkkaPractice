package Akka.Poc1

import Akka.Http.Server.system.executionContext
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.server.Directives._
import Akka.Poc1.Repo._
import Akka.Poc1.model.Customer
import akka.actor.typed.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}

import scala.io.StdIn

object application {
  def main(args: Array[String]): Unit = {
    implicit val system:ActorSystem[Nothing]= ActorSystem(Behaviors.empty,"actorsystem1")
    val route=
    path("customer") {
      get {
        complete(HttpEntity(ContentTypes.`application/json`, "Get all data"))
      }
      post {
        complete(HttpEntity(ContentTypes.`application/json`, "Posted all data"))
      }
    }
      val bindingFuture = Http().newServerAt("localhost",8081).bind(route)
      println(s"Server started at http://localhost:8081/customer\n Press Return to stop")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_=>system.terminate())

    }
  }
