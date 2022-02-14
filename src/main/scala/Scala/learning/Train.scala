package Scala.learning

case class Station(name:String)
case class Train(kind:String,number:Int,schedule:Seq[(Time,Station)])  {
  require(schedule.take(2).size==2,"Schedule must contain w elements")

  val stations:Seq[Station]=schedule.map(_._2)
}
