package Scala.learning.testExercise

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import json.Employee

object json extends App {
    case class Employee(Name:String,Role:String,Salary:Int)
    val emp1=Employee("sai","analyst",21000)
    val emp2=Employee("bob","technician",20000)
    val emp3=Employee("alexa","support",15000)

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  val m=mapper.writeValueAsString(emp1,emp2,emp3)
  println(m)

}
object json2 extends App{
  val jsonString="""
       {
        "Name":"chris"
        "Role":"Developer"
        "Salary":36000
       }"""
   val mapper=new ObjectMapper()
   mapper.registerModule(DefaultScalaModule)
  val m=mapper.readValue(jsonString,classOf[Employee])
  println(m)
}