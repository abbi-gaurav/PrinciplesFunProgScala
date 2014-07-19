package week7_2

object LazyVal extends App {
  val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
  
  fibs take 5 foreach println
}