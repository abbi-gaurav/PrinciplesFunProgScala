package week6

trait Expr {
	def eval : Int
}

class Num(n:Int) extends Expr{
  def eval = n
}

class Sum(e1:Expr, e2:Expr) extends Expr{
  def eval = e1.eval + e2.eval
}