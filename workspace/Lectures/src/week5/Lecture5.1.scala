package week5
object lecture51{
  def last[T](xs : List[T]):T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }
  
  def init [T](xs :List[T]):List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }
  def concat[T](xs:List[T], ys:List[T]):List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs,ys)
  } 
  
  def reverse[T](xs:List[T]):List[T] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  }
    
  def removeAt[T](n:Int, xs:List[T]) = (xs take n) ::: (xs drop n + 1) 

}

//xs ++ ys
//xs.reverse
//xs update(n,x)
//
//xs indexOf x
//xs contains x
//xs.length
//xs.last
//xs.init -- like tail but in the other wat
//xs take n -- list containt the first n elements
//xs drop n -- the rest of the collection after taking n
//xs(n) 