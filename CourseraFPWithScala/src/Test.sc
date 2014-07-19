import week4.ListFunc
import week7.ListFuncs
import scala.math.Ordering

object Test {
  (1 to 2).toList.sliding(2).map(xs=>xs.head+xs.tail.head).toList
                                                  //> res0: List[Int] = List(3)
  val set = "this is a test".toList.toSet         //> set  : scala.collection.immutable.Set[Char] = Set(e, s, t, a, i,  , h)
  
  set.map(c=>(c,1))                               //> res1: scala.collection.immutable.Set[(Char, Int)] = Set((e,1), (t,1), ( ,1),
                                                  //|  (s,1), (h,1), (a,1), (i,1))
                                                  
  case class Sample(wt:Int){}
  
  val list =  List(new Sample(2), new Sample(3))  //> list  : List[Test.Sample] = List(Sample(2), Sample(3))
  val idx = list.indexWhere(p=>p.wt > 2)          //> idx  : Int = 1
  
  val x = Char.MaxValue                           //> x  : Char = ?
  
 (0 to 10).toList.splitAt(5)                      //> res2: (List[Int], List[Int]) = (List(0, 1, 2, 3, 4),List(5, 6, 7, 8, 9, 10))
                                                  //| 
 val p = ("g",34)                                 //> p  : (String, Int) = (g,34)
 
 val (labe,value) = p                             //> labe  : String = g
                                                  //| value  : Int = 34
 def isG(p:(String,Int)) = p match {
  case ("g",_) => true
  case (_,34) => true
  case _ => false
 }                                                //> isG: (p: (String, Int))Boolean
 
 val nums = List(3,-8, 7,33, 56)                  //> nums  : List[Int] = List(3, -8, 7, 33, 56)
 val fruits = List("apple", "banana","pineapple", "orange", "grapes")
                                                  //> fruits  : List[String] = List(apple, banana, pineapple, orange, grapes)
 
 //ListFuncs.mSort(nums)((x:Int, y:Int) => x < y)
 ListFuncs.mSort(nums)(Ordering.Int)              //> res3: List[Int] = List(-8, 3, 7, 33, 56)
 
 ListFuncs.mSort(fruits)(Ordering.String)         //> res4: List[String] = List(apple, banana, grapes, orange, pineapple)
 
 ListFuncs.mSort(fruits)                          //> res5: List[String] = List(apple, banana, grapes, orange, pineapple)
 
 (1 to 3).toList                                  //> res6: List[Int] = List(1, 2, 3)
}