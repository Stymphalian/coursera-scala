package week6

import scala.collection.immutable.IndexedSeq

object Lecture62 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
 
  //val n = 7
  val n = 7                                       //> n  : Int = 7
  val xs = ( 1 until n) map ( i =>
  	(1 until i) map ( j => (i,j)))            //> xs  : scala.collection.immutable.IndexedSeq[scala.collection.immutable.Index
                                                  //| edSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), V
                                                  //| ector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6,1)
                                                  //| , (6,2), (6,3), (6,4), (6,5)))
  
  xs.foldRight(scala.collection.immutable.IndexedSeq[Any]()) ( (x,y) => x ++ y)
                                                  //> res0: scala.collection.immutable.IndexedSeq[Any] = Vector((2,1), (3,1), (3,2
                                                  //| ), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,3), (6,
                                                  //| 4), (6,5))
  xs.flatten                                      //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))
                                                  
 // xs flatMap f  = (xs map f).flatten
 
  val xs2 = ( 1 until n) flatMap ( i =>
 	    ( 1 until i) map ( j => (i,j)))       //> xs2  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6
                                                  //| ,3), (6,4), (6,5))
  
	def isPrime(n : Int) = (2 until n) forall ( x => n%x != 0)
                                                  //> isPrime: (n: Int)Boolean
	isPrime(1)                                //> res2: Boolean = true
	isPrime(2)                                //> res3: Boolean = true
	isPrime(3)                                //> res4: Boolean = true
	isPrime(8)                                //> res5: Boolean = false
	isPrime(9)                                //> res6: Boolean = false
	
	xs2.filter( x => isPrime( x._1 + x._2))   //> res7: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
                                                  
	case class Person(name: String, age:Int)
	val persons = List( Person("jordan",22), Person("Wesley",26), Person("Crystal",21), Person("Emily",28))
                                                  //> persons  : List[week6.Lecture62.Person] = List(Person(jordan,22), Person(Wes
                                                  //| ley,26), Person(Crystal,21), Person(Emily,28))
	for ( p <- persons if p.age > 20) yield p.name
                                                  //> res8: List[String] = List(jordan, Wesley, Crystal, Emily)
	persons filter( p => p.age > 20) map ( p => p.name)
                                                  //> res9: List[String] = List(jordan, Wesley, Crystal, Emily)
                                                  
  //for (s) yeild e
  //where s is a sequenc eof generators or filters
  //e is an expression whose value is returned by an iteration
  
  //generator is of the form p <- e, where p is a pattern and e an epxression whose value is a collection
  //filter is of the form if f where f is a predicate
  
  for {
  	i <- 1 until n
  	j <- 1 until i
  	if isPrime(i +j )
  } yield (i,j)                                   //> res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,2), (4,1), (4,3), (5,2), (6,1), (6,5))
  def scalarProduct( xs: List[Double], ys :List[Double]) :Double =
	  (for ((x,y) <- xs zip ys) yield x*y).sum//> scalarProduct: (xs: List[Double], ys: List[Double])Double
	  
	scalarProduct(List(1,2,3,4),List(1,2,3,4))//> res11: Double = 30.0
}