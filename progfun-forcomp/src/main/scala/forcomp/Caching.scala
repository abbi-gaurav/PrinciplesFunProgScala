package forcomp

object Caching extends App {
	class MemoStringFunction[T](f: String => T, x: String) {
		private lazy val v = f(x)

		private lazy val ts = (for {
			tx <- 'a' to 'z'
		} yield (tx, new MemoStringFunction(f, x + tx))).toMap

		private def get(x: String): T = x match {
			case "" => v
			case s => ts(s.head).get(s.tail)
		}

		def apply(x: String) = get(x)
	}

	val f = new MemoStringFunction(s => { println("bork."); s.length }, "")
	println(f("a"))
	
	println(f("abcdef"))
	
	println(f("a"))
	
	println(f("abcdef"))

}