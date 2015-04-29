package week5
import math.Ordering

object lecture53 {
  
  def msort[T](xs:List[T])(lt: (T,T)=>Boolean): List[T]  = {
    val n = xs.length /2
    if( n == 0) xs
    else {
      
      def merge(xs:List[T], ys:List[T]):List[T] = (xs,ys) match {        
        case (Nil,y) => y
        case (x,Nil) => x
        case (x :: x_rest,y :: y_rest) =>
          if( lt(x,y)) x :: merge(x_rest,ys)
          else y :: merge(xs,y_rest)                
      }
      
      val (fst,snd)=  xs splitAt n
      merge(msort(fst)(lt),msort(snd)(lt))
    }    
  }
  
  
  scala.math.Ordering
  def msort_ord[T](xs:List[T])(implicit ord:Ordering[T]): List[T]  = {
    val n = xs.length /2
    if( n == 0) xs
    else {
      
      def merge(xs:List[T], ys:List[T]):List[T] = (xs,ys) match {        
        case (Nil,y) => y
        case (x,Nil) => x
        case (x :: x_rest,y :: y_rest) =>
          if( ord.lt(x,y)) x :: merge(x_rest,ys)
          else y :: merge(xs,y_rest)                
      }
      
      val (fst,snd)=  xs splitAt n
      merge(msort_ord(fst)(ord),msort_ord(snd)(ord))
    }    
  }
  
  // implicit paramters
  // say a functoin takes an implicit parameter of type T
  // compiler will search an implict definition that satisfies
//  1. marked implicit
//  2. has a a type compatible wiht T
//  3. is visible at the point of the funcion call, or is defined
//    in a companion object associated with T
//    
//    It will take the singel most specific definition

}