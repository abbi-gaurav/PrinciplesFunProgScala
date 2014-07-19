package week7

import java.lang.Boolean
import scala.math.Ordering

object ListFuncs {
  def concat[T](xs: List[T], ys: List[T]): List[T] = (xs) match {
    case List() => ys
    case x :: xsT => x :: concat(xsT, ys)
  }

  def removeAt[T](n: Int, list: List[T]) = (list take n) ::: (list drop n + 1)

  def mSort[T](list: List[T])(implicit ord:Ordering[T]): List[T] = {
    val n = list.length / 2
    if (n == 0) list
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs,ys) match{
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x::xs1, y::ys1) => if (ord.lt(y, x)) y :: merge(xs,ys1) else x :: merge(xs1,ys)
      }
      val (fst, snd) = list splitAt n
      merge(mSort(fst), mSort(snd))
    }
  }
}