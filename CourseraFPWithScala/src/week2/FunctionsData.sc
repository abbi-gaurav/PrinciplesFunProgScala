package week2


object FunctionsData {
  val x = new Rational(1,3)                       //> x  : week2.Rational = 1/3
  x.num                                           //> res0: Int = 1
  x.den                                           //> res1: Int = 3
  
  val y = new Rational(5,7)                       //> y  : week2.Rational = 5/7
  
  x + (y)                                         //> res2: week2.Rational = 22/21
  
  val z = new Rational(3,2)                       //> z  : week2.Rational = 3/2
  x - y - z                                       //> res3: week2.Rational = -79/42
  
  y + (y)                                         //> res4: week2.Rational = 10/7
  
  x < y                                           //> res5: Boolean = true
  
  x max z                                         //> res6: week2.Rational = 3/2
  
  x + y                                           //> res7: week2.Rational = 22/21
  
  new week2.Rational(7,8)                         //> res8: week2.Rational = 7/8
}