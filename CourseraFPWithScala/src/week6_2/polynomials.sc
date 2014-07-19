package week6_2

object polynomials {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Poly(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    
    val terms = terms0 withDefaultValue 0.0
    
    //def + (other: Poly) = new Poly (terms ++ (other.terms map adjust))
    
    def +(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    
    def addTerm(acc: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      acc + (exp -> (coeff + terms(exp)))
    }
    
    def adjust(term: (Int, Double)) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }

    override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 5.0, 5 -> 5.2) //> p1  : week6_2.polynomials.Poly = 5.2x^5 + 5.0x^3 + 2.0x^1
  val p2 = new Poly(Map(0 -> 1.5, 2 -> 5.9, 4 -> 3.9, 3 -> 2.0))
                                                  //> p2  : week6_2.polynomials.Poly = 3.9x^4 + 2.0x^3 + 5.9x^2 + 1.5x^0

  p1 + p2                                         //> res0: week6_2.polynomials.Poly = 5.2x^5 + 3.9x^4 + 7.0x^3 + 5.9x^2 + 2.0x^1 
                                                  //| + 1.5x^0
}