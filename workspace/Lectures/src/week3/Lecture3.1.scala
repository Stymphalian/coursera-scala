package week3
object lecture31{
abstract class IntSet {
    def incl(x:Int):IntSet
    def contains(x:Int):Boolean
    def union(other:IntSet):IntSet
}

class NonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet {
    def contains(x:Int): Boolean = {
        if(x < elem) left.contains(x)
        else if( x > elem) right.contains(x)
        else true
    }

    def incl(x:Int):IntSet = {
        if(x < elem) new NonEmpty(x,left.incl(x), right)
        else if( x > elem) new NonEmpty(x,left,right.incl(x))
        else this
    }

    // for some reason I couldn't think of how to do this...
    def union(other:IntSet) = {
        ((left union right) union other) incl elem
    }

    override def toString() = "{" + left + elem + right  + "}"
}

class Empty extends IntSet {
    def contains(x:Int): Boolean  = false
    def incl(x:Int):IntSet = new NonEmpty(x,new Empty, new Empty)
    def union(other:IntSet) =  other
    override def toString() = "."
}

// singlton object.
// object Empty extends IntSet {
//     def contains(x:Int): Boolean  = false
//     def incl(x:Int):IntSet = new NonEmpty(x,Empty,Empty)
//     override def toString() = "."
// }

// persistent data structures
val t1 = new NonEmpty(3,new Empty, new Empty)
val t2 = t1 incl 4


abstract class Base {
    def foo = 1
    def bar :Int
}
class Sub extends Base {
    override def foo = 2
    // don't need the override here becuase we are only implementing it
    def bar = 3
}

object Hello {
    def main(args:Array[String]) = println("Hello World")
}
}