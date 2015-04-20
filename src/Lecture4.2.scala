// trait List[T]{
//     def isEmpty:Boolean
//     def head: T
//     def tail: List[T]
// }

// class Cons[T](val head:T, val tail:List[T]) extends List[T] {
//     def isEmpty:Boolean  = false
// }

// class Nil[T] extends List[T] {
//     def isEmpty:Boolean = true
//     def head:Nothing = throw new NoSuchElementException("Nil.head")
//     def tail:Nothing = throw new NoSuchElementException("Nil.tail")
// }

// object List {
//     def apply[T]():List[T] = new Nil
//     def apply[T](c1:T): List[T] = new Cons(c1, new Nil)
//     def apply[T](c1:T,c2:T): List[T] = new Cons(c1, new Cons(c2,new Nil))
// }

package idealized.scala

abstract class MyBoolean {
    def ifThenElse[T](t: => T, e: => T):T
    def && ( x: => MyBoolean): MyBoolean = ifThenElse(x,MyFalse)
    def || ( x: => MyBoolean): MyBoolean = ifThenElse(MyTrue,x)
    def unary_!():MyBoolean = ifThenElse(MyFalse,MyTrue)

    def ==(x:MyBoolean):MyBoolean = ifThenElse(x,x.unary_!)
    def !=(x:MyBoolean):MyBoolean = ifThenElse(x.unary_!,x)

    def <(x:MyBoolean):MyBoolean  = ifThenElse(MyFalse,x)
}

object MyTrue extends MyBoolean {
    def ifThenElse[T](t: => T, e: => T) = t
}
object MyFalse extends MyBoolean {
    def ifThenElse[T](t: => T, e: => T) = e
}

abstract class Nat {
    def isZero():MyBoolean
    def predecessor():Nat
    def successor():Nat = new Succ(this)
    def + (that:Nat):Nat
    def - (that:Nat):Nat
}

object Zero extends Nat {
    def isZero():MyBoolean = MyTrue
    def predecessor():Nat = throw new Error("No predecessor to Zero")
    def + (that:Nat):Nat = that
    def - (that:Nat):Nat = that.isZero().ifThenElse(this,throw new Error("Can't subtract from Zero"))
}

class Succ(n:Nat) extends Nat{
    def isZero():MyBoolean = MyFalse
    def predecessor():Nat = n
    def + (that:Nat):Nat = new Succ(n + that)
    def - (that:Nat):Nat = {
        that.isZero().ifThenElse(this,(this - that.predecessor).predecessor)
    }
}

// :load Main.scala
// a.predecessor
// Zero.isZero()
// Zero.successor()
// Zero + Zero
// Zero - Zero
// val a = new Succ(Zero)
// a.isZero()
// a.predecessor()
// val two = new Succ( new Succ(Zero))
// val one = new Succ(Zero)
// val four = new Succ(new Succ( new Succ(Zero)))
// val four = new Succ(new Succ(new Succ( new Succ(Zero))))
// val three = new Succ(new Succ( new Succ(Zero)))
// four + three
// (two + two)
// (two + two).predecessor
// (two + two).predecessor predecessor
// (two + two).predecessor.predecessor
// (two + two).predecessor.predecessor.predecessor
// (two + two).predecessor.predecessor.predecessor.predecessor
// two - two
// three -two
// (three -two).predecessor
