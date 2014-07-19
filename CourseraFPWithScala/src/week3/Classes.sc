package week3
import week2.Rational
import week2.{ Handy }

object Classes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  new Rational(1, 7)                              //> res0: week2.Rational = 1/7
  Hello.main(_)                                   //> res1: Array[String] => Unit = <function1>

  new Handy("Nokia", "1234")                      //> res2: week2.Handy = week2.Handy@30d60f6e

  def error(message: String) = throw new Error(message)
                                                  //> error: (message: String)Nothing
  val x = null                                    //> x  : Null = null
  
  val y:String = x;                               //> y  : String = null
  
}