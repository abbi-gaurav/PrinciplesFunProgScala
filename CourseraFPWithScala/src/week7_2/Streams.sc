package week7_2

object Streams {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  (1 to 10).toStream                              //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)

  (1 to 10).toList                                //> res1: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  def isPrime(n: Int): Boolean = (2 until math.sqrt(n).toInt) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
  ((1000 to 10000).toStream filter isPrime)(1)    //> res2: Int = 1013
  ((1000 to 10000).toList filter isPrime)(1)      //> res3: Int = 1013

  3 #:: Stream(3, 4)                              //> res4: scala.collection.immutable.Stream[Int] = Stream(3, ?)

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo + " ")
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]

  streamRange(1, 10).take(3).toList               //> 1 2 3 res5: List[Int] = List(1, 2, 3)

  def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
  }                                               //> expr: => Int
  
  expr                                            //> xzyzres6: Int = 12
  
  
}