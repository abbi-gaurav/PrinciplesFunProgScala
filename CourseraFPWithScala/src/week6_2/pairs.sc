package week6_2

object pairs {
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
  val n = 7                                       //> n  : Int = 7
  val pairs = (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))
                                                  //> pairs  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (
                                                  //| 3,2), (4,1), (4,3), (5,2), (6,1), (6,5))

  case class Person(name: String, age: Int)
  val persons = List(Person("ss", 29), Person("ga", 31))
                                                  //> persons  : List[week6_2.pairs.Person] = List(Person(ss,29), Person(ga,31))
  for (p <- persons if p.age > 20) yield p.name   //> res0: List[String] = List(ss, ga)

  for {
    i <- (1 until n)
    j <- (1 until i)

    if (isPrime(i + j))
  } yield (i, j)                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  (1 until n) flatMap (
    i => (1 until i) withFilter (j => isPrime(i + j)) map (j => (i, j)))
                                                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    (for {
      (x, y) <- xs zip ys
    } yield (x * y)).sum                          //> scalarProduct: (xs: List[Double], ys: List[Double])Double
}