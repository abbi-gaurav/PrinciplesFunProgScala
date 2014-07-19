package week6

object TestPatternMatching {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val exp = Summation(Number(1), Number(6))       //> exp  : week6.Summation = Summation(Number(1),Number(6))
  PatternMatching.show(exp)                       //> res0: String = 1 + 6
  PatternMatching.eval(exp)                       //> res1: Int = 7
  Summation(Number(2), Number(5)).eval            //> res2: Int = 7
  
  val fruits = "apple" :: ("chikuu" :: ("pineapple" :: Nil))
                                                  //> fruits  : List[String] = List(apple, chikuu, pineapple)
  //cons operator is right associative, so parenthesis can be omitted
  val nums = 1 :: 2 :: 3 :: 4 :: Nil              //> nums  : List[Int] = List(1, 2, 3, 4)
}