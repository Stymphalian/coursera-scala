package week4

object lecture47 {
  
  val fruit = List("apples","oranges","pears")
  val nums = List(1,2,3,4)
  // lists are all homongenous
  var diag3 = List(List(1,0,0),List(0,1,0),List(0,0,1))
  
  //fruit = "apples" :: ("oranges" :: ("pears" :: Nil))  
//  1 :: 2 :: xs
//  x :: Nil
//  List(x)
//  List()
//  List( 2 :: xs)
  
  def insert(x:Int, xs:List[Int]):List[Int] = xs match {
    case List() =>  List(x) 
    case y :: ys => {
      if( y > x)  x :: y :: ys      
      else y :: insert(x,ys)
    }
  }
  
  def isort( xs:List[Int]): List[Int] = xs match{
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

}