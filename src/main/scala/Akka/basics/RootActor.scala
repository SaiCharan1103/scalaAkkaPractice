package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}

class RootActor extends Actor{
  def receive:Receive={
    case msg:String =>println(msg+" "+self.path.name)
      val childActor = context.actorOf(Props[Child], "Child")
      childActor ! "Hello"
  }
}
class Child extends Actor{
  def receive:Receive = {
    case msg:String => println(msg+" "+self.path.name)
  }
}
object ChildActorExample{
  def main(args:Array[String]): Unit = {
    val actorSystem = ActorSystem()
    val actor = actorSystem.actorOf(Props[RootActor], "RootActor")
    actor ! "Hello"
  }
}