package week7

import sun.misc.Sort

object Assignment {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val y = "abacd".toList.groupBy(identity).toList.map(p=>(p._1,p._2.length)).sortWith((p1,p2)=>p1._1 < p2._1)
                                                  //> y  : List[(Char, Int)] = List((a,2), (b,1), (c,1), (d,1))
  val  list = ('a' to 'b').toList.map(c=>(c,2))   //> list  : List[(Char, Int)] = List((a,2), (b,2))
  
 def combinations(occurrences: List[(Char,Int)]): List[List[(Char,Int)]] = occurrences match {
    case Nil => List()
    case x :: xs => {
      val unfiltered = for {
        n <- (0 to x._2)
        tails <- combinations(xs)
      } yield {
        (x._1,n) :: tails
      }
      unfiltered.toList
    }
  }                                               //> combinations: (occurrences: List[(Char, Int)])List[List[(Char, Int)]]
  
  combinations(list)                              //> res0: List[List[(Char, Int)]] = List()
}