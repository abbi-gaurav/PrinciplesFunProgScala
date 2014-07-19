package week3

import scala.util.Random
 
object ClassHierarchies {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val t1 = new NonEmpty(1, Empty, Empty)          //> t1  : week3.NonEmpty = {.1.}
  val t2 = t1 incl 4                              //> t2  : week3.NonEmpty = {.1{.4.}}

  Random.shuffle((0 to 7).toList).foldLeft(Empty: IntSet)((set: IntSet, x: Int) => set incl x)
                                                  //> res0: week3.IntSet = {{{{.0.}1.}2.}3{{{.4.}5{.6.}}7.}}
                                                  

}