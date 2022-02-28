package Akka.Poc.endpoints

import Akka.Poc.Repo._
import Akka.Poc.model._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.Location
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.Materializer
import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport._

import scala.concurrent.ExecutionContext

class UserEndpoint(repository: UserRepository)(implicit ec: ExecutionContext, mat: Materializer) {
  val userRoutes: Route =
    pathPrefix("api" / "users") {
      (get & path(Segment).as(FindByIdRequest)) { request =>
        onSuccess(repository.findById(request.id)) {
          case Some(user) =>
            complete(StatusCodes.OK -> user)
          case None       =>
            complete(StatusCodes.NotFound)
        }
      } ~ (post & pathEndOrSingleSlash & entity(as[User])) { user =>
        onSuccess(repository.save(user)) { id =>
          respondWithHeader(Location(s"/api/users/$id")) {
            complete(StatusCodes.Created)
          }
        }
      }
    }
}