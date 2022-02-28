package Akka.Db

case class User(id: Option[Int], email: String,
                firstName: Option[String], lastName: Option[String])

case class Address(id: Option[Int], userId: Int,
                   addressLine: String, city: String, postalCode: String)