package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}

class Actortell extends Actor {
  def receive: Receive = {
    case message:String => println("Message received: "+message+ " from - "+ self.path.name)
      println("sender:"+ sender())  // returns ActorRef
//      val child = context.actorOf(Props[Actortell], "ChildActor")
//      child ! "hello"
//      context.stop(child)
  }
}
object Actortell{
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem("ActorSystem")
    val actor = actorSystem.actorOf(Props[Actortell], "RootActor")
    actor ! "Hello"             // Sending message by using !
    actor.tell("Hello",null)  // Sending message by using tell() method
    // Sender is not passed here.
    actor.tell("Hi Sai",null)
//    actorSystem.stop(actor)
//    actorSystem.terminate()
  }
}
