package wee4
object lecture43{

  // S < - suptype
  // S > - super type
  // [S>: NonEmpty <: IntSet]
  
  // covariant
  // if a <: B then everyting one can to do with a vlaue of type B one
  // should also be able to to do with a vlaue of type A
  
  // let q(x) be a property provable about objext x of type B
  // then q(y) should be provable for object y of type A where A < : B
  
//  def assertAllPs[S <: IntSet](r:S):S
//  val a: Array[NonEmpty] = Array(new NonEmpty(1,Empty,Empty))
//  val b: Array[IntSet] = a
//  b(0) = Empty
//  val s: NonEmpty = a(0)
  // type error on line 14
}