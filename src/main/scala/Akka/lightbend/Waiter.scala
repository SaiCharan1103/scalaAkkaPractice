package Akka.lightbend

import Akka.lightbend.Waiter.{CoffeeServed, serveCoffee}
import akka.actor.{Actor, ActorLogging, Props}

object Waiter{
  case class serveCoffee(coffee: Coffee)
  case class CoffeeServed(coffee: Coffee)
  def props():Props=Props(new Waiter)
}
class Waiter extends Actor with ActorLogging{
  override def receive:Receive={
    case serveCoffee(coffee) =>sender() ! CoffeeServed(coffee)
  }
}
case class Coffee(favoritecoffee:String)