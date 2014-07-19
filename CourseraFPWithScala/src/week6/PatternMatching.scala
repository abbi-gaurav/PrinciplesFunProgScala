package week6

object PatternMatching {
  def eval(e: Expression): Int = e match {
    case Number(n) => n
    case Summation(e1, e2) => eval(e1) + eval(e2)
  }

  def show(e: Expression): String = e match {
    case Number(n) => "" + n
    case Summation(e1, e2) => show(e1) + " + " + show(e2)
  }

  def isort(list: List[Int]): List[Int] = {
    
    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => x :: Nil
      case y :: ys => if (y > x) x :: xs else y :: insert(x, ys)
    }
    
    list match {
      case List() => List()
      case x :: xs => insert(x, isort(xs))
    }
  }
}

trait Expression {
  def eval: Int = this match {
    case Number(n) => n
    case Summation(e1, e2) => e1.eval + e2.eval
  }
}

case class Number(n: Int) extends Expression

case class Summation(e1: Expression, e2: Expression) extends Expression