package week3

object TypeParameters {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def singleton[T](elem:T):List[T] = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week3.List[T]
  
  singleton(5)                                    //> res0: week3.List[Int] = week3.Cons@2cce3e17
  singleton(true)                                 //> res1: week3.List[Boolean] = week3.Cons@184e6efc
  singleton('c')                                  //> res2: week3.List[Char] = week3.Cons@45586edb
  
  def nth[T](n:Int, list:List[T]):T =
    if(n <0 || list.isEmpty) throw new IndexOutOfBoundsException
    else if(n == 0) list.head
    else nth(n-1, list.tail)                      //> nth: [T](n: Int, list: week3.List[T])T
    
 
 val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4,new Nil))))
                                                  //> list  : week3.Cons[Int] = week3.Cons@30d60f6e
 nth(1,list)                                      //> res3: Int = 2
 
 
 nth(4,list)                                      //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week3.TypeParameters$$anonfun$main$1.nth$1(week3.TypeParameters.scala
                                                  //| :12)
                                                  //| 	at week3.TypeParameters$$anonfun$main$1.apply$mcV$sp(week3.TypeParameter
                                                  //| s.scala:21)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.TypeParameters$.main(week3.TypeParameters.scala:3)
                                                  //| 	at week3.TypeParameters.main(week3.TypeParameters.scala)
}