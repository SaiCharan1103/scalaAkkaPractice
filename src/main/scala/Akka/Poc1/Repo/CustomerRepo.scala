package Akka.Poc1.Repo

import Akka.Poc1.model.Customer
import java.sql.Connection

trait CustomerRepo{
  def save(connection: Connection,customer: Customer):Unit
}
