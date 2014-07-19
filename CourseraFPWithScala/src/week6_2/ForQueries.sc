package week6_2

object ForQueries {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  case class Book(title: String, authors: List[String])

  val books: Set[Book] = Set(
    Book(title = "Structure and Interpretation of Computer Programs",
      authors = List("Abelson, Harald", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming",
      authors = List("Bird, Richard", "Wadler, Phil2")),
    Book(title = "Effective Java",
      authors = List("Bloch, Joshua")),
    Book(title = "Effective Java 2",
      authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers",
      authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala",
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")))
                                                  //> books  : Set[week6_2.ForQueries.Book] = Set(Book(Effective Java 2,List(Bloch
                                                  //| , Joshua)), Book(Programming in Scala,List(Odersky, Martin, Spoon, Lex, Venn
                                                  //| ers, Bill)), Book(Structure and Interpretation of Computer Programs,List(Abe
                                                  //| lson, Harald, Sussman, Gerald J.)), Book(Effective Java,List(Bloch, Joshua))
                                                  //| , Book(Introduction to Functional Programming,List(Bird, Richard, Wadler, Ph
                                                  //| il2)), Book(Java Puzzlers,List(Bloch, Joshua, Gafter, Neal)))

  for {
    b <- books
    a <- b.authors
    if a startsWith "Bird"
  } yield b.title                                 //> res0: scala.collection.immutable.Set[String] = Set(Introduction to Functiona
                                                  //| l Programming)
  books.filter(b => b.authors exists (a => a startsWith "Bird")) map (b=>b.title)
                                                  //> res1: scala.collection.immutable.Set[String] = Set(Introduction to Functiona
                                                  //| l Programming)
  books flatMap (b => b.authors withFilter (a => a startsWith "Bird") map (an=>b.title))
                                                  //> res2: scala.collection.immutable.Set[String] = Set(Introduction to Function
                                                  //| al Programming)
  for (b <- books if b.title contains "Program") yield b.title
                                                  //> res3: scala.collection.immutable.Set[String] = Set(Programming in Scala, St
                                                  //| ructure and Interpretation of Computer Programs, Introduction to Functional
                                                  //|  Programming)

  for {
    b1 <- books
    b2 <- books

    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors

    if a1 == a2
  } yield a1                                      //> res4: scala.collection.immutable.Set[String] = Set(Bloch, Joshua)
}