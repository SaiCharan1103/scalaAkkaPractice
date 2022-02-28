package Akka.Db

//trait AddressesTable extends UsersTable { this: Db =>
//  import config.driver.api._
//
//  private class Addresses(tag: Tag) extends Table[Address](tag, "ADDRESSES") {
//    // Columns
//    def id = column[Int]("ADDRESS_ID", O.PrimaryKey, O.AutoInc)
//    def addressLine = column[String]("ADDRESS_LINE")
//    def city = column[String]("CITY")
//    def postalCode = column[String]("POSTAL_CODE")
//
//    // ForeignKey
//    def userId = column[Int]("USER_ID")
//    def userFk = foreignKey("USER_FK", userId, users)
//    (_.id, ForeignKeyAction.Restrict, ForeignKeyAction.Cascade)
//
//    // Select
//    def * = (id.?, userId, addressLine, city, postalCode) <>
//      (Address.tupled, Address.unapply)
//  }
//
//  val addresses = TableQuery[Addresses]
//}