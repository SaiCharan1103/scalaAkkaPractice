package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class actorAsk extends Actor{
  def receive:Receive={
    case message:String => println("Message received: "+message+" from outside actor instance")
      println("Replaying")
      val senderName = sender()
      senderName ! "Hello, I got your message."
  }
}
object actorAsk{
  def main(args: Array[String]): Unit = {
    val actorsystem=ActorSystem("actorsystem")
    val actor=actorsystem.actorOf(Props[actorAsk],"RootActor")
    implicit val timeout: Timeout =Timeout(10 seconds)
    val future =actor ? "Hello"
    val result=Await.result(future,timeout.duration)
    println("Message received: " + result)
  }
}