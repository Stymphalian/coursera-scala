// say C[T] is a parametertized type and A, B are type such that A <: B
// 3 possible relationships
// C[A] <: C[B]                                            covariant
// C[A] >: C[B]                                            contravariant
// neither C[A] nor C[B] is a subtype of the other         nonvariant


// class C[+A]{...}    // covariant
// class C[-A]{...}    // contravariant
// class C[A]{...}    // nonvariant

// if A2 <: A1 and B1 <: B2 then
// A1 => B1 <: A2 => B2

// functions are contravariant for arguments, covariant in result
// trait Function1[-T,+U]{
//     def apply(x:T):U
// }

// package jordan

trait List[+T]{
    def isEmpty:Boolean
    def head: T
    def tail: List[T]
    // def prepend(elem:T):List[T] = new Cons(elem,this)
    def prepend[U >: T](elem:U):List[U] = new Cons(elem,this)
}

class Cons[T](val head:T, val tail:List[T]) extends List[T] {
    def isEmpty:Boolean  = false
}

object Nil extends List[Nothing] {
    def isEmpty:Boolean = true
    def head:Nothing = throw new NoSuchElementException("Nil.head")
    def tail:Nothing = throw new NoSuchElementException("Nil.tail")
}

def f(xs:List[NonEmpty],x: Empty) = { xs.prepend(x)}

IntSet <- NonEmpty
IntSet <- Empty