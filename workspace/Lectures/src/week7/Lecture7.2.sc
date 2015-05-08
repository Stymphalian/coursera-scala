package week7

object Lecture72 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def isPrime(i : Int) : Boolean = {
  	(2 until i) forall ( x => i%x != 0)
  }                                               //> isPrime: (i: Int)Boolean
  isPrime(1)                                      //> res0: Boolean = true
  isPrime(2)                                      //> res1: Boolean = true
  isPrime(3)                                      //> res2: Boolean = true
  isPrime(7)                                      //> res3: Boolean = true
  isPrime(9)                                      //> res4: Boolean = false
  isPrime(11)                                     //> res5: Boolean = true
  //((1000 to 10000) filter isPrime)(1)
  
  // Stream.cons(1,Stream.cons(2,Stream.empty)))
  // Stream(1,2,3)
  // #::  -- cons for streams
  (1 to 1000).toStream(1)                         //> res6: Int = 2
  
  
  // object Stream {
  // note the pass by ref for the tl paramter
  // def cons[T](hd :T, tl: => Stream[T]) = new Stream[T] {
  // def isEmpty = false
  // def head = hd
  // def tail = tl
  // }
  // val empty = new Stream[Nothing] {
  //		def isEmpty = true
  // 		def head = throw new NoSuchElementException("empty.head")
  // 		def tail = throw new NoSuchElementExcetpion("empty.tail")
  //}
  //}
  
  def streamRange(lo:Int,hi:Int): Stream[Int] = {
  	print(lo +" ")
  	if(lo >= hi) Stream.empty
  	else Stream.cons(lo,streamRange(lo+1,hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]
  streamRange(1,10).take(3).toList                //> 1 2 3 res7: List[Int] = List(1, 2, 3)
}