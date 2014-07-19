package week2

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def sumOfFuncs(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumOfFuncs(f, a + 1, b)
                                                  //> sumOfFuncs: (f: Int => Int, a: Int, b: Int)Int

  def sumInts(a: Int, b: Int) = sumOfFuncs(x => x, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int

  def sumCubes(a: Int, b: Int) = sumOfFuncs(x => x * x * x, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int

  def sumOfFuncsWithTailR(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }                                               //> sumOfFuncsWithTailR: (f: Int => Int, a: Int, b: Int)Int

  sumOfFuncsWithTailR(x => x * x * x, 1, 3)       //> res0: Int = 36

  def sumCurried(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }
    sumF
  }                                               //> sumCurried: (f: Int => Int)(Int, Int) => Int
  sumCurried(x => x * x)(1, 4)                    //> res1: Int = 30

  (sumCurried(x => x * x))(1, 4)                  //> res2: Int = 30

  def sumCurried2(f: Int => Int)(a: Int, b: Int): Int = if (a > b) 0 else f(a) + sumCurried2(f)(a + 1, b)
                                                  //> sumCurried2: (f: Int => Int)(a: Int, b: Int)Int
  def sumCube = sumCurried2(x => x * x * x)_      //> sumCube: => (Int, Int) => Int
  sumCube(1, 3)                                   //> res3: Int = 36

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    Math.abs((x - y) / x) < tolerance             //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

  fixedPoint(x => 1 + x / 2)(1)                   //> res4: Double = 1.9998779296875
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)
                                                  //> sqrt: (x: Double)Double
  sqrt(2.0)                                       //> res5: Double = 1.4142135623746899
  sqrt(3.0)                                       //> res6: Double = 1.7320508100147274

  def avgDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> avgDamp: (f: Double => Double)(x: Double)Double
  def sqrtWithAvgDamp(x: Double) = fixedPoint(avgDamp(y => x / y))(1.0)
                                                  //> sqrtWithAvgDamp: (x: Double)Double
  sqrtWithAvgDamp(2.0)                            //> res7: Double = 1.4142135623746899

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * (product(f)(a + 1, b))            //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x=>x)(1,5)                              //> res8: Int = 120
  
  def fact(x:Int):Int = product(x=>x)(1, x)       //> fact: (x: Int)Int
  
  fact(5)                                         //> res9: Int = 120
  
  def mapReduce(f:Int=>Int, combine:(Int,Int)=>Int,zero:Int)(a:Int,b:Int):Int=
    if(a > b) zero
    else combine(f(a),mapReduce(f, combine, zero)(a+1,b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int

  mapReduce(x=>x, (a:Int,b:Int)=>a*b, 1)(1, 5)    //> res10: Int = 120
}