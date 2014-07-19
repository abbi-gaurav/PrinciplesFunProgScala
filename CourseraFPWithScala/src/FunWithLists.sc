object FunWithLists {
 val nums = List(3,-8, 7,33, 56)                  //> nums  : List[Int] = List(3, -8, 7, 33, 56)
 val fruits = List("apple", "banana","pineapple", "orange", "grapes")
                                                  //> fruits  : List[String] = List(apple, banana, pineapple, orange, grapes)
 nums filter (x => x >0)                          //> res0: List[Int] = List(3, 7, 33, 56)
 nums filterNot (x => x > 0 )                     //> res1: List[Int] = List(-8)
 
 nums partition (x => x>0)                        //> res2: (List[Int], List[Int]) = (List(3, 7, 33, 56),List(-8))
 
 nums takeWhile (x => x>0)                        //> res3: List[Int] = List(3)
 
 nums dropWhile (x => x>0 )                       //> res4: List[Int] = List(-8, 7, 33, 56)
 
 nums span (x => x >0 )                           //> res5: (List[Int], List[Int]) = (List(3),List(-8, 7, 33, 56))
 
 def pack[T](xs : List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (fst, snd) = xs span (y => y == x)
    fst :: pack(snd)
 }                                                //> pack: [T](xs: List[T])List[List[T]]
 
 val dataList = List('a','a','a','b','b','c','c','c','d','a')
                                                  //> dataList  : List[Char] = List(a, a, a, b, b, c, c, c, d, a)
 pack(dataList)                                   //> res6: List[List[Char]] = List(List(a, a, a), List(b, b), List(c, c, c), List
                                                  //| (d), List(a))
                                                  
 def encode[T](list:List[T]):List[(T,Int)] = pack(list) map (ys=> (ys.head,ys.length))
                                                  //> encode: [T](list: List[T])List[(T, Int)]
 encode(dataList)                                 //> res7: List[(Char, Int)] = List((a,3), (b,2), (c,3), (d,1), (a,1))
}