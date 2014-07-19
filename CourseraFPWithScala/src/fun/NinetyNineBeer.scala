package fun

object NinetyNineBeer extends App {
  def bottleNumber(n: Int) = if (n != 0) n.toString else "no more"

  val song = for (x <- 99 to 0 by -1) yield {
    val bn = bottleNumber(x)
    bn + " bottles of beer on the wall," + bn + " bottles of beer\n" +
      (if (x != 0) "Take one down and pass it around, " + (x - 1) else "Go to the store and buy some more, 99") +
      " bottles of beer on the wall.\n"
  }
  println(song.mkString)
}