package week5

object lecture52 {
  
  def msort(xs:List[Int]): List[Int]  = {
    val n = xs.length /2
    if( n == 0) xs
    else {
      
      def merge(xs:List[Int], ys:List[Int]): List[Int] = xs match {        
        case Nil => ys
        case x :: x_rest => ys match {
          case Nil => xs
          case y :: y_rest =>
            if( x < y )  x :: merge(x_rest,ys)
            else y :: merge(xs,y_rest)
        }          
      }
      
      def merge_pairs(xs:List[Int], ys:List[Int]):List[Int] = (xs,ys) match {        
        case (Nil,y) => y
        case (x,Nil) => x
        case (x :: x_rest,y :: y_rest) =>
          if( x < y) x :: merge_pairs(x_rest,ys)
          else y :: merge_pairs(xs,y_rest)                
      }
      
      val (fst,snd)=  xs splitAt n
      merge(msort(fst),msort(snd))
    }    
  }
  
  val nums = List(2,4,5,7,1)
  msort(nums)
}