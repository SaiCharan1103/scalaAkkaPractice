package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}

class PropsExample extends Actor {
  def receive:Receive= {
    case msg:String => println(msg+" "+self.path.name)
  }
}
object PropsMain{
  def main(args:Array[String]): Unit = {
    val actorSystem = ActorSystem("ActorSystem")
    val actor = actorSystem.actorOf(Props[PropsExample], "PropExample")
    actor ! "Hello from"
  }
}