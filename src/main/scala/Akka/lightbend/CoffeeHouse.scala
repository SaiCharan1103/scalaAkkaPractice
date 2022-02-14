package Akka.lightbend

import Akka.lightbend.CoffeeHouse.CreateGuest
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

import java.util.concurrent.TimeUnit
import scala.concurrent.duration._

object CoffeeHouse{
  case class CreateGuest(favoriteCoffee:Coffee)
  def props():Props=Props(new CoffeeHouse)
}
class CoffeeHouse extends Actor with ActorLogging {
  private val finishCoffeeDuration:FiniteDuration=
    context.system.settings.config.getDuration("coffee-house.guest.finish-coffee-duration",TimeUnit.MILLISECONDS).millis
  private val waiter:ActorRef=createWaiter()
  protected def createGuest(favoriteCoffee:Coffee):ActorRef=
    context.actorOf(Guest.props(waiter,favoriteCoffee,finishCoffeeDuration))
  protected def createWaiter():ActorRef=context.actorOf(Waiter.props(),"waiter1")
     val system: ActorSystem =ActorSystem("coffee-house-system")
      system.terminate()
    override def receive: Receive = {
      case CreateGuest=> createGuest(favoriteCoffee=Coffee("Cafficuino"))
   }
  }