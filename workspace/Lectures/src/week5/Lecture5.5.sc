package week5

object Lecture55 {
  // ( _ *_ )  <= (( x,y) => x *  y ))
  // reduceLeft - cannt be used with empty list
  // foldLeft - uses an accumulator paramter
  
  val mynums = List(1,2,3,4,5)                    //> mynums  : List[Int] = List(1, 2, 3, 4, 5)
  def mysum (xs:List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> mysum: (xs: List[Int])Int
  mysum(mynums)                                   //> res0: Int = 15
  
  // def foldLeft[U](z:U)(op: (U,T) => U) : U = this match {
  //	case Nil => z
  //	case y :: ys => (ys foldLeft op(z,y))(op)
  //}
  
  // def foldRight[U](acc:U)(op: (U,T) => U) : U = this match {
  //	case Nil => acc
  //	case y :: ys => op(y,(ys foldRight acc)(op))
  //}
}