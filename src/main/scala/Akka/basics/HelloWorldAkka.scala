package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}

class HelloWorldAkka extends Actor {
  def receive: Receive = {
    case msg: String => println(msg)
    case _ => println("Unknown message") // Default case
  }

  object Main {
    def main(args: Array[String]) {
      var actorSystem = ActorSystem("ActorSystem") // Creating ActorSystem
      var actor = actorSystem.actorOf(Props[HelloWorldAkka], "HelloAkka") //Creating actor
      actor ! "Hello Akka" // Sending messages by using !
      actor ! 100.52
    }
  }
}