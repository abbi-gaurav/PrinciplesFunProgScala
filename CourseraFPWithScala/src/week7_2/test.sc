package week7_2

object test {
  val problem = new Pouring(Vector(4, 9,19))      //> problem  : week7_2.Pouring = week7_2.Pouring@127bf607
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7_2.test.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0), Fill
                                                  //| (1), Fill(2), Pour(0,0), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,1), Pour(1,2
                                                  //| ), Pour(2,0), Pour(2,1), Pour(2,2))
  
  problem.solution(17)                            //> res1: Stream[week7_2.test.problem.Path] = Stream(Fill(0) Fill(1) Pour(0,2) P
                                                  //| our(2,2) Pour(1,2)-->Vector(0, 0, 17), ?)
}