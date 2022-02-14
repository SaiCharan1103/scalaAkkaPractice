package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}

class LifeCycleMethod extends Actor{
  def receive: Receive = {
    case msg:String => println(msg+" "+self.path.name)  // Getting name of Actor
  }
  override def preStart(): Unit = {    // overriding preStart method
    println("preStart method is called")
  }
  override def postStop(): Unit = {    // Overriding postStop method
    println("postStop method is called")
  }
}
object ActorMain{
  def main(args:Array[String]): Unit = {
    val actorSystem = ActorSystem("ActorSystem")
    val actor = actorSystem.actorOf(Props[LifeCycleMethod],"RootActor")
    actor ! "Hello"

    println("stopping Actor")
    actorSystem.stop(actor)
  }
}