package week6

object Lecture63 {
  val fruit = Set("apple", "bannana", "orange")   //> fruit  : scala.collection.immutable.Set[String] = Set(apple, bannana, orange)
                                                  //| 
  (1 to 5).toSet                                  //> res0: scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 4)
  // contains
  
  
  def queens(n :Int) : Set[List[Int]] = {
  	def placeQueens(k:Int): Set[List[Int]] = {
  		if(k == 0) Set(List())
  		else
  			for {
  				qs <- placeQueens(k-1)
  				col <- 0 until n
  				if( isSafe(col,qs))
  			} yield col :: qs
  	}
  	  	
  	placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]
  
  def isSafe(col:Int, qs:List[Int]):Boolean = {
  	val row = qs.length
  	val queensWithRows = ((row-1 to 0 by -1) zip qs)
  	queensWithRows forall {
  		case(r,c) => col != c  && (math.abs(col-c) != (row -r))
  	}
  }                                               //> isSafe: (col: Int, qs: List[Int])Boolean
  	
  queens(4)                                       //> res1: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))

	def show(queens:List[Int]) = {
		val lines =
			for (col <- queens.reverse)
			yield Vector.fill(queens.length)("* ").updated(col,"X ").mkString
			"\n" + (lines mkString "\n")
	}                                         //> show: (queens: List[Int])String
	(queens(4) map show) mkString "\n"        //> res2: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "
	(queens(8) take 3 map show) mkString "\n" //> res3: String = "
                                                  //| * * * * * X * * 
                                                  //| * * * X * * * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * X * * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * * X * * * "
}