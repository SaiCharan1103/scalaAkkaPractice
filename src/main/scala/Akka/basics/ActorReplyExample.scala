package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}

class ActorReplyExample extends Actor{
  def receive: Receive = {
    case message:String => println("Message recieved from "+sender.path.name+" massage: "+message)
      val child = context.actorOf(Props[ActorChildReplyExample],"ActorChild")
      child ! "Hello Child"
  }
}
class ActorChildReplyExample extends Actor{
  def receive: Receive ={
    case message:String => println("Message recieved from "+sender.path.name+" massage: "+message)
      println("Replying to "+sender().path.name)
      sender()! "I got your message"
  }
}
object ActorReplyExample{
  def main(args:Array[String]): Unit = {
    val actorSystem = ActorSystem("ActorSystem")
    val actor = actorSystem.actorOf(Props[ActorReplyExample], "RootActor")
    actor ! "Hello"
  }
}