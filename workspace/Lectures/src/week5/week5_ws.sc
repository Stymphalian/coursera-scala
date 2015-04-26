package week5

object week5_ws {

	def reverse2[T](xs:List[T]):List[T] = {
		def inner (xs:List[T],acc:List[T]):List[T] = xs match {
			case List() => acc
			case y :: ys => inner(ys,y :: acc)
		}
		inner(xs,List())
  }                                               //> reverse2: [T](xs: List[T])List[T]
    
  reverse2(List(1,2,3))                           //> res0: List[Int] = List(3, 2, 1)
  reverse2(List(1,2,3,4,5,6))                     //> res1: List[Int] = List(6, 5, 4, 3, 2, 1)
}