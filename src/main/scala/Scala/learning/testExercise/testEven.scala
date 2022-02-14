package Scala.learning.testExercise

object testEven extends App {
  val v = List(1, 2, 3, 4, 5, 6, 7)
  val m= v.groupBy(i => i % 2 == 0).headOption
 val m1= v.filter(i=>i%2==0)
println(m)
  println(m1)
}
