// package scala
// trait Function1[A,B]{
//     def apply(x:A):B
// }

// (x:Int) => x*x
// {class AnonFun extends Functoin1[Int,Int]{
//     def apply(x:Int) = x*x
// }
//     new AnonFun
// }

val f = new Function[Int,Int] {
    def apply(x:Int) = x*x
}
f.apply(7)

// def f(x:Int):Boolean =...
// (x:Int) => f(x)
// eta expansion



trait List[T]{
    def isEmpty:Boolean
    def head: T
    def tail: List[T]
}

class Cons[T](val head:T, val tail:List[T]) extends List[T] {
    def isEmpty:Boolean  = false
}

class Nil[T] extends List[T] {
    def isEmpty:Boolean = true
    def head:Nothing = throw new NoSuchElementException("Nil.head")
    def tail:Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
    def apply[T]():List[T] = new Nil
    def apply[T](c1:T): List[T] = new Cons(c1, new Nil)
    def apply[T](c1:T,c2:T): List[T] = new Cons(c1, new Cons(c2,new Nil))
}

println(List().isEmpty)
println(List(1).head)
println(List(1,2).tail.head)