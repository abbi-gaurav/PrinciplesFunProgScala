package week5

abstract class Bool {
	def ifThenElse[T](t:T,e:T):T
	
	def && (x: => Bool):Bool = ifThenElse(x, False)
	
	def || (x: => Bool):Bool = ifThenElse(True, x)
	
	def unary_! : Bool = ifThenElse(False, True)
	
	def == (x: Bool):Bool = ifThenElse(x, x.unary_!)
	
	def != (x:Bool):Bool = this.==(x).unary_!
	
	def < (x: Bool): Bool = ifThenElse(False, x)
}

object False extends Bool{
  def ifThenElse[T](t:T,e:T) = e
}

object True extends Bool{
  def ifThenElse[T](t:T, e:T) = t
}