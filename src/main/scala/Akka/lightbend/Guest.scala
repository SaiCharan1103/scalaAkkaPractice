package Akka.lightbend

import Akka.lightbend.Guest.CoffeeFinished
import akka.actor.{Actor, ActorLogging, ActorRef, Props, Timers}

import scala.concurrent.duration.FiniteDuration

object Guest{
  case object CoffeeFinished
  def props(waiter: ActorRef,favoriteCoffee:Coffee,finishCoffeeDuration:FiniteDuration):Props=
    Props(new Guest(waiter, favoriteCoffee,finishCoffeeDuration))
}
class Guest(waiter: ActorRef,favoriteCoffee:Coffee,finishCoffeeDuration:FiniteDuration)
  extends Actor with ActorLogging with Timers{
  private val coffeeCount: Int = 0

  orderCoffee()

  override def receive:Receive=onMessage(coffeeCount)
  private def orderCoffee():Unit={
    waiter ! Waiter.CoffeeServed(favoriteCoffee)
  }

  private def onMessage(coffeeCount: Int): Receive = {
    case Waiter.CoffeeServed(coffee) =>
      context.become(onMessage(coffeeCount + 1))
      log.info(s"Enjoying my $coffeeCount yummy $coffee")
      timers.startSingleTimer("coffee-finished", CoffeeFinished, finishCoffeeDuration)
    case CoffeeFinished =>
      waiter ! Waiter.serveCoffee(favoriteCoffee)
  }
}