package Scala.learning

object looptest extends App {
  val l1=List(1,2,3)
  val l2=for(f1<-l1) yield f1+1
  println(l1)
    println(l2)

}
