package Scala.learning

case class Time (hours:Int=0,minutes:Int=0){
  require(hours>=0&&hours<24,"Invalid hour ")
  require(minutes>=0&&minutes<60,"Invalid minutes ")
  val asMinutes:Int=hours*60+minutes
  def minus(that:Time):Int=asMinutes-that.asMinutes
}
object Time {
  def main(args: Array[String]): Unit = {
    def fromMinutes(m: Int): Unit = {
      val hours = m / 60
      val minutes = m % 60
      Time(hours, minutes)
    }
  }
}