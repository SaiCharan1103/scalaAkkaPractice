package Akka.test.employee

import java.lang.annotation.Documented
import java.time.LocalDate

@Documented
case class Employee(_id:String,name:String,dateOfBirth:LocalDate)
