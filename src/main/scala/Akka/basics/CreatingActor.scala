package Akka.basics

import akka.actor.{Actor, ActorSystem, Props}

class CreatingActor extends Actor{
  def receive:Receive={
    case msg:String=>println(msg+""+self.path.name)
  }
}
object CreatingActor{
  def main(args: Array[String]): Unit = {
    val actorSystem=ActorSystem("ActorSystem")
    val props1 = Props[CreatingActor]  // creating props here
    val actor1 = actorSystem.actorOf(props1)  // passing props reference
    val actor2 = actorSystem.actorOf(Props[CreatingActor], "Actor2") // Passing pops and explicitly giving name to the actor
    val actor3 = actorSystem.actorOf(Props(classOf[CreatingActor]), "Actor3") // Passing actor class by using classOf
    val actor4 = actorSystem.actorOf(Props[CreatingActor], name = "Actor4") // Name passing to variable
    val actor5 = actorSystem.actorOf(Props(new CreatingActor()), name = "Actor5") // This approach is not recommended
    actor1 ! "Hello "
    actor2 ! "Hello "
    actor3 ! "Hello "
    actor4 ! "Hello "
    actor5 ! "Hello "
  }
}