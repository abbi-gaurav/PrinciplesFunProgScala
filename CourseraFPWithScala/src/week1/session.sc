package week1

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def abs(x: Double) = if (x >= 0) x else -x      //> abs: (x: Double)Double
  def sqrt(x: Double) = {
    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnf(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def sqrItr(guess: Double): Double =
      if (isGoodEnf(guess)) guess
      else sqrItr(improve(guess))

    sqrItr(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(1e-06)                                     //> res2: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res3: Double = 1.0000788456669446E30
  
  def fact(x:Int):Int = {
    def loop(acc:Int, n:Int):Int =
      if(n == 0) acc
      else loop(acc*n, n-1)
      
      loop(1,x)
  }                                               //> fact: (x: Int)Int
  
  fact(5)                                         //> res4: Int = 120
  
  3 < 5                                           //> res5: Boolean(true) = true
}