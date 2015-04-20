// package week4;

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

def singleton[T](elem:T) = new Cons[T](elem,new Nil[T])

singleton[Int](1)
singleton[Boolean](true)


def findNth[T](n:Int,xs:List[T]):T = {
    if( n < 0 || xs.isEmpty) throw new IndexOutOfBoundsException("findNth " + n)
    if(xs.isEmpty) throw new IndexOutOfBoundsException("findNth " + n)
    if( n == 0) xs.head
    else findNth(n-1,xs.tail)
}


// sub-typing
// polymorphism
// generics

// type erasure
singleton[Int](1) // inference
singleton[Boolean](true)
singleton(1) // inference
singleton(true)

val a = new Cons(1,new Cons(2,new Cons(3, new Nil())))
findNth(0,a)
findNth(1,a)
findNth(2,a)
findNth(3,a)
findNth(-1,a)