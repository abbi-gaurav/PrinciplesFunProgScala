package week2

class Rational(x: Int, y: Int) {
  require(y > 0, "den should be positive"+y)
  private def gcd(a:Int,b:Int):Int = if(b==0) a else gcd(b,a%b)
  private val g = gcd(Math.abs(x),Math.abs(y))
  def num = x / g
  def den = y / g
  
  def this(x:Int) = this(x,1)
  
  def + (that: Rational) =
    new Rational((this.num * that.den + that.num * this.den), this.den * that.den)

  def unary_- : Rational = new Rational(-num, den)

  def - (that: Rational) =
    this + -that

  def mul(that: Rational) =
    new Rational(this.num * that.num, this.den * that.den)

  def < (that:Rational) = num*that.den < that.num*den
  
  def max(that:Rational) = if(this < that) that else this
  
  override def toString() = num + "/" + den
}