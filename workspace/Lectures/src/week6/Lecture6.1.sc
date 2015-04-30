package week6

object Lecture61 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // Vector
  val things = Vector(1,2,3,4)                    //> things  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4)
  
  // add to front
  val nums2 = 2 +: things                         //> nums2  : scala.collection.immutable.Vector[Int] = Vector(2, 1, 2, 3, 4)
  
  // add to end
  val nums3  = things :+ 2                        //> nums3  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 2)
  
  
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map ( x => x *2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
    
  val r : Range = 1 until 5                       //> r  : Range = Range(1, 2, 3, 4)
  val rs : Range = 1 to 5                         //> rs  : Range = Range(1, 2, 3, 4, 5)
  1 to 10 by 3                                    //> res2: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res3: scala.collection.immutable.Range = Range(6, 4, 2)
  
  val pairs = r zip rs                            //> pairs  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (
                                                  //| 2,2), (3,3), (4,4))
  pairs unzip                                     //> res4: (scala.collection.immutable.IndexedSeq[Int], scala.collection.immutabl
                                                  //| e.IndexedSeq[Int]) = (Vector(1, 2, 3, 4),Vector(1, 2, 3, 4))
  
  s flatMap(c => List('.',c))                     //> res5: String = .H.e.l.l.o. .W.o.r.l.d
  
  
  r.sum                                           //> res6: Int = 10
  r.max                                           //> res7: Int = 4
  r.min                                           //> res8: Int = 1
  
  
  def scalarProduct(a : Vector[Double], b:Vector[Double]) ={
  	(a zip b).map{ case (x,y) => x* y}.sum
  	//(a zip b).map(case (x,y)=> x * y).sum
  }                                               //> scalarProduct: (a: Vector[Double], b: Vector[Double])Double
  scalarProduct(Vector(1,2,3,4), Vector(1,2,3,4)) //> res9: Double = 30.0
  
  
  val ador = 5 % 2                                //> ador  : Int = 1
  val jordan = 1 to 10                            //> jordan  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 
                                                  //| 6, 7, 8, 9, 10)
  val a = 3                                       //> a  : Int = 3
  jordan.filter{x => a%x == 0}.length == 2        //> res10: Boolean = true
  def isPrime(n :Int):Boolean = {
  	(2 until n) forall { x => n %x != 0}
  	//(1 to n).filter{a => (n % a == 0)}.length == 2
  }                                               //> isPrime: (n: Int)Boolean
  
  isPrime(1)                                      //> res11: Boolean = true
  isPrime(2)                                      //> res12: Boolean = true
  isPrime(3)                                      //> res13: Boolean = true
  isPrime(7)                                      //> res14: Boolean = true
  isPrime(9)                                      //> res15: Boolean = false

  // sequences
  // xs exists p
  // xs forall p
  // xs zip ys
  // xs unzip
  // xs flatMap f
  // xs sum
  // xs product
  // xs max
  // xs min
  
}