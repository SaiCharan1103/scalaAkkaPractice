package Akka.Poc1.mysql

import java.sql.{Connection, DriverManager}

object ScalaJdbcConnectSelect extends App {
  // connect to the database named "mysql" on port 8889 of localhost
  val url = "jdbc:mysql://localhost:8889/mysql"
  val driver = "com.mysql.cj.jdbc.Driver"
  val username = "root"
  val password = "root"
  var connection:Connection = _
  try {
    // make the connection
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)

    //create the statement,and run the select query
    val statement = connection.createStatement()
    val rs = statement.executeQuery("SELECT host, user FROM user")
    while (rs.next) {
      val host = rs.getString("host")
      val user = rs.getString("user")
      println("host = %s, user = %s".format(host,user))
    }
  } catch {
    case e: Exception => e.printStackTrace()
  }
   connection.close()
}
