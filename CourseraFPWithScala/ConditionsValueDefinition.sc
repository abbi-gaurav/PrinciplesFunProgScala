object ConditionsValueDefinition {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
 def loop:Boolean = loop                          //> loop: => Boolean
 def and(x:Boolean, y: =>Boolean) = if (x) y else false
                                                  //> and: (x: Boolean, y: => Boolean)Boolean
 def or(x:Boolean, y: =>Boolean) = if(x) x else y //> or: (x: Boolean, y: => Boolean)Boolean
 
 
 and(false,loop)                                  //> res0: Boolean = false
 
 or(true, loop)                                   //> res1: Boolean = true
}