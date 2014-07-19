package recfun
import common._

object Main {
	def main(args: Array[String]) {
		println("Pascal's Triangle")
		for (row <- 0 to 10) {
			for (col <- 0 to row)
				print(pascal(col, row) + " ")
			println()
		}
	}

	/**
	 * Exercise 1
	 */
	def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c, r - 1) + pascal(c - 1, r - 1)

	/**
	 * Exercise 2
	 */
	def balance(chars: List[Char]): Boolean = {
		def loop(acc: Int, chars: List[Char]): Int = {
			if (chars.isEmpty || acc < 0) {
				acc
			} else {
				val x = chars.head
				if (x == '(') loop(acc + 1, chars.tail)
				else {
					if (x == ')') loop(acc - 1, chars.tail) else loop(acc, chars.tail)
				}
			}
		}
		loop(0, chars) == 0
	}

	/**
	 * Exercise 3
	 */
	def countChange(money: Int, coins: List[Int]): Int = {
		if(coins.isEmpty || money < 0){
			0
		}else {
			if(money == 0) 1
			else countChange(money-coins.head, coins) + countChange(money, coins.tail)
		}
	}
}
