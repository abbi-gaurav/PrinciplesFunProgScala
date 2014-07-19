package week6_2

object ForAndHOF {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def mapFun[T,U](list:List[T], f: T=>U):List[U] = for(x <- list) yield f(x)
                                                  //> mapFun: [T, U](list: List[T], f: T => U)List[U]
  def flatMap[T,U](xs:List[T], f: T=>Iterable[U]):List[U] = for(x <- xs; y <- f(x)) yield y
                                                  //> flatMap: [T, U](xs: List[T], f: T => Iterable[U])List[U]
  def filter[T] (xs : List[T], f:T=>Boolean):List[T] = for(x <- xs if f(x)) yield x
                                                  //> filter: [T](xs: List[T], f: T => Boolean)List[T]
    
  
}