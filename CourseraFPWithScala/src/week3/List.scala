package week3


trait List[+T] {
	def isEmpty:Boolean
	def head:T
	def tail:List[T]
	def prepend[U >: T](elem:U):List[U] = new Cons(elem,this)
}

class Cons[T](val head:T, val tail:List[T]) extends List[T] {
  override def isEmpty = false
}

object Nill extends List[Nothing] {
  override def isEmpty = true
  override def head:Nothing = throw new NoSuchElementException("Nil.head")
  override def tail:Nothing = throw new NoSuchElementException("Nil.tail")
}

object Test{
  val x:List[String] = Nill
  
  def f(x:List[NonEmpty]):List[IntSet] = x prepend Empty
}
