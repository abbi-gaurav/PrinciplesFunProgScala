package week4

import week3.Nill
import week3.Cons

object ListFunc {
	def apply[T]() = Nill
	
	def apply[T](x:T) = new Cons(x, Nill)
	
	def apply[T](x:T,y:T) = new  Cons(x,new Cons(y,Nill))
}