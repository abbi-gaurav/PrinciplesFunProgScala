package week6_2

object Test {
  val a = Array(1,2,3,4)                          //> a  : Array[Int] = Array(1, 2, 3, 4)
  a map (x => x*2)                                //> res0: Array[Int] = Array(2, 4, 6, 8)
  
  val s = "Shwetha Shenoy"                        //> s  : String = Shwetha Shenoy
  s filter (c=>c.isLower)                         //> res1: String = hwethahenoy
  
  val r = 1 to 10 by 2                            //> r  : scala.collection.immutable.Range = Range(1, 3, 5, 7, 9)
  val u = 1 until 10 by 2                         //> u  : scala.collection.immutable.Range = Range(1, 3, 5, 7, 9)
  
  val pairs = (1 to 3).toList zip s               //> pairs  : List[(Int, Char)] = List((1,S), (2,h), (3,w))
  
  val uz = pairs.unzip                            //> uz  : (List[Int], List[Char]) = (List(1, 2, 3),List(S, h, w))
  
  (s flatMap (c=>List(".",c))).mkString           //> res2: String = .S.h.w.e.t.h.a. .S.h.e.n.o.y
  
  def combinations(m:Int,n:Int) = (1 to m) flatMap (x => (1 to n) map (y => (x,y)))
                                                  //> combinations: (m: Int, n: Int)scala.collection.immutable.IndexedSeq[(Int, In
                                                  //| t)]
  def scalarProduct(xs:Vector[Double], ys:Vector[Double]):Double = (xs zip ys).map{case (x,y)=>x * y}.sum
                                                  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
  
}