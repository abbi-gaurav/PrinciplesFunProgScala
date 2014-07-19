package week6_2

object nqueens {
  def queens(n: Int): Set[List[Int]] = {
    def placeQueen(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueen(k - 1)
          col <- 0 until n

          if (isSafe(col, queens))
        } yield col :: queens
    }

    placeQueen(n)
  }                                               //> queens: (n: Int)Set[List[Int]]

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val rows = queens.length
    val queensWithRows = (rows - 1 to 0 by -1) zip (queens)

    queensWithRows forall {
      case (r, c) => col != c && (math.abs(col - c) != rows - r)
    }
  }                                               //> isSafe: (col: Int, queens: List[Int])Boolean

  def show(queens:List[Int]) ={
    val lines =
      for (n <- queens.reverse)
      yield Vector.fill(queens.length)("* ").updated(n, "X ").mkString
      "\n"+(lines mkString "\n")
  }                                               //> show: (queens: List[Int])String
  (queens(8) take 3 map show) mkString "\n"       //> res0: String = "
                                                  //| * * * * * X * * 
                                                  //| * * * X * * * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * X * * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * * X * * * "
}