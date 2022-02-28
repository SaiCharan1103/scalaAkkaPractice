package Akka.test

import akka.actor.typed.ActorSystem
import akka.stream.alpakka.slick.scaladsl._
import akka.stream.scaladsl._
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.{GetResult, JdbcProfile}

object mysqlConnection {
//  implicit val system: Any = ActorSystem()
  implicit val session: SlickSession = SlickSession.forConfig("slick-h2")
  val db = Database.forConfig("slick-h2.db")
  val profile = slick.jdbc.H2Profile
  val slickSessionCreatedForDbAndProfile: SlickSession = SlickSession.forDbAndProfile(db, profile)
//  system.registerOnTermination(() => session.close())

}
