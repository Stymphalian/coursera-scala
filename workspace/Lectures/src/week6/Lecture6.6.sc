package week6

object Lecture66 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //Map[Key,Value]
  val romanNumerals = Map("I" -> 1, "V" ->5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V 
                                                  //| -> 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
	capitalOfCountry("US")                    //> res0: String = Washington
	capitalOfCountry get "Canada"             //> res1: Option[String] = None
	capitalOfCountry get "US"                 //> res2: Option[String] = Some(Washington)
	
	
	//trait Option[+A]
	//case class Some[+A](value : A) extends Option[A]
	//object None extends Option[Nothing]
	//capitalOfCountry("Canada")
	
	//def showCapital(country:String) = capitalOfCountry.get(country) match {
  //		case Some(capital) => capital
  //		case None => "missing data"
	//}
	//showCapital("US")
	//showCaptial("Canada")
	val fruit = List("apple","pear","orange","pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
	fruit sortWith( _.length < _.length)      //> res3: List[String] = List(pear, apple, orange, pineapple)
	fruit.sorted                              //> res4: List[String] = List(apple, orange, pear, pineapple)
	fruit.groupBy( _.head)                    //> res5: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
	
  class Poly(terms0: Map[Int,Double]) {

		// repeated parameter
  	def this(bindings:(Int,Double)*) = {
  		this(bindings.toMap)
  	}
  
  	val terms = terms0 withDefaultValue 0.0
  	def + (other:Poly) = {
  		//new Poly(terms ++ other.terms)
  		//new Poly(terms ++ (other.terms map adjust))
  		new Poly((other.terms foldLeft terms)(addTerm))
  	}
  	
  	def addTerm(terms :Map[Int,Double], term :(Int,Double)):Map[Int,Double] = {
  		val (exp,coeff) = term
  		terms + (exp -> (terms(exp) + coeff))
  	}
  	
  	def adjust(term :(Int,Double)):(Int,Double) = {
	  		val (exp,coeff) = term
	  		return (exp, coeff + terms(exp))
	  		//terms get exp match {
	  		// case Some(coeff1) => (exp,(coeff + coeff1))
	  		// case None => term
	  		//}
  	}
  	
  	override def toString = {
  		(for((exp,coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
  	}
  }
  val p1 = new Poly(Map(1 -> 2.0, 3->4.0, 5 -> 6.2))
                                                  //> p1  : week6.Lecture66.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  //val p1 = new Poly(1 -> 2.0, 3->4.0, 5 -> 6.2)
  val p2 = new Poly(Map(0 -> 3.0, 3 ->7.0))       //> p2  : week6.Lecture66.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> res6: week6.Lecture66.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
  
  // withDefaultValue
}