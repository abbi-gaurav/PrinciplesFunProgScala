package week6_2

object maps {
  val romanNumerals = Map("I"->1, "V"->5, "X"->10)//> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
  val capitalOfCountry = Map("India"->"Delhi", "Switzerland"->"Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(Indi
                                                  //| a -> Delhi, Switzerland -> Bern)
  capitalOfCountry("India")                       //> res0: String = Delhi
  
  //romanNumerals("D")
  romanNumerals get "D"                           //> res1: Option[Int] = None
  romanNumerals get "I"                           //> res2: Option[Int] = Some(1)
  
  def getDecimalValue(x:String) = romanNumerals get x match {
    case Some(value) => value
    case None => -1
  }                                               //> getDecimalValue: (x: String)Int
  
  val fruits = List("apple", "pear","pineapple","orange","banana")
                                                  //> fruits  : List[String] = List(apple, pear, pineapple, orange, banana)
  
  fruits sortWith (_.length < _.length)           //> res3: List[String] = List(pear, apple, orange, banana, pineapple)
  
  fruits sorted                                   //> res4: List[String] = List(apple, banana, orange, pear, pineapple)
  
  fruits groupBy (_.head)                         //> res5: scala.collection.immutable.Map[Char,List[String]] = Map(b -> List(bana
                                                  //| na), p -> List(pear, pineapple), a -> List(apple), o -> List(orange))
}