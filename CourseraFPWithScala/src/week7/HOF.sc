package week7

object HOF {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sum(list : List[Int]) = (0 :: list) reduceLeft (_ + _)
                                                  //> sum: (list: List[Int])Int
  def prod(list : List[Int]) = (1 :: list) reduceLeft (_ * _)
                                                  //> prod: (list: List[Int])Int
  def sum2(xs : List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sum2: (xs: List[Int])Int
  def prod2(xs:List[Int]) = xs.foldLeft(1)(_ * _) //> prod2: (xs: List[Int])Int
}