package week6

object Lecture64 {

  case class Book(title:String, authors:List[String])
	val books = Set(
		Book(
			title="Structure and Interpretation of Computer Programs",
			authors = List("Abelson, Harald","Sussmand, Gerald J.")),
		Book(
			title="Introduction to Functionall Programming",
			authors = List("Bird, Richard","Wadler, Phil")),
		Book(
			title="Effective Java",
			authors = List("Bloch, Joshua")),
		Book(
			title="Effective Java2",
			authors = List("Bloch, Joshua")),
		Book(
			title="Java Puzzlers",
			authors = List("Bloch, Joshua", "Gafter, Neal")),
		Book(
			title="Programming in Scala",
			authors = List("Odersky, Martin","Spoon, Lex","Venners, Bill"))
	)                                         //> books  : scala.collection.immutable.Set[week6.Lecture64.Book] = Set(Book(Pro
                                                  //| gramming in Scala,List(Odersky, Martin, Spoon, Lex, Venners, Bill)), Book(Ef
                                                  //| fective Java2,List(Bloch, Joshua)), Book(Effective Java,List(Bloch, Joshua))
                                                  //| , Book(Introduction to Functionall Programming,List(Bird, Richard, Wadler, P
                                                  //| hil)), Book(Structure and Interpretation of Computer Programs,List(Abelson, 
                                                  //| Harald, Sussmand, Gerald J.)), Book(Java Puzzlers,List(Bloch, Joshua, Gafter
                                                  //| , Neal)))
	for {
		b <- books
		a <- b.authors
		if( a startsWith "Block,")
	} yield b.title                           //> res0: scala.collection.immutable.Set[String] = Set()
	
	for {
	 	b1 <- books
	 	b2 <- books
	 	if( b1.title < b2.title)
	 	//if b1 != b2
	 	a1 <- b1.authors
	 	a2 <- b2.authors
	 	if (a1 == a2)
	} yield a1                                //> res1: scala.collection.immutable.Set[String] = Set(Bloch, Joshua)
	
	/*(for {
	 	b1 <- books
	 	b2 <- books
	 	if( b1.title < b2.title)
	 	//if b1 != b2
	 	a1 <- b1.authors
	 	a2 <- b2.authors
	 	if (a1 == a2)
	} yield a1
	).distinct*/
}