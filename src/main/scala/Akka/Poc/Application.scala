package Akka.Poc

import Akka.Http.Server.system
import Akka.Http.SprayJsonExample.system.executionContext
import Akka.Poc.Repo.UserRepository
import Akka.Poc.endpoints._
import Akka.Poc.mongoDB.Mongo
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route

object Application extends App {
  protected def routes: Route =
    new UserEndpoint(new UserRepository(Mongo.userCollection)).userRoutes//you can add more routes using the '~' to concatenate: val routes = route1 ~ route2 ~ route3
  Http().newServerAt("0.0.0.0", 8080).bind(routes)
}