package week5

object Lecture54 {

	def squareList(xs:List[Int]):List[Int] = xs match {
		case Nil => Nil
		case x :: rest => x*x :: squareList(rest)
	}                                         //> squareList: (xs: List[Int])List[Int]
	
	def squareList2(xs:List[Int]):List[Int] = xs map (x => x*x)
                                                  //> squareList2: (xs: List[Int])List[Int]
	
	squareList(List(1,2,3,4))                 //> res0: List[Int] = List(1, 4, 9, 16)
	squareList2(List(1,2,3,4))                //> res1: List[Int] = List(1, 4, 9, 16)
	
	//def filter(p :T => Boolean):List[T] = this match {
 	//	case Nil => this
	//	case x ::xs => if ( p(x) ) x :: xs.filter(p) else xs.filter(p)
	//}
	
	// filterNot
	// parittion
	// takeWhilte
	// dropWhile
	// span
	
	val nums = List(2,-4,5,7,1)               //> nums  : List[Int] = List(2, -4, 5, 7, 1)
	val fruits = List( "apple","pineapple","orange","banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
	
	nums filter( x => x > 0)                  //> res2: List[Int] = List(2, 5, 7, 1)
	nums filterNot ( x => x >0 )              //> res3: List[Int] = List(-4)
	nums partition (x => x > 0)               //> res4: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
	
	nums takeWhile ( x => x > 0)              //> res5: List[Int] = List(2)
	nums dropWhile ( x => x > 0)              //> res6: List[Int] = List(-4, 5, 7, 1)
	nums span( x => x > 0)                    //> res7: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
	
	
	val data = List("a","a","a","b","c","c","c","a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, c, a)
	def pack[T]( xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: rest =>
			xs span(y => y == x) match {
				case (a,b) => a :: pack(b)
			}
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	pack(data)                                //> res8: List[List[String]] = List(List(a, a, a), List(b), List(c, c, c), List(
                                                  //| a))
	
	def encode[T](xs:List[T]): List[(T,Int)] = pack(xs) map ( x => (x.head, x.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
	encode(data)                              //> res9: List[(String, Int)] = List((a,3), (b,1), (c,3), (a,1))
}