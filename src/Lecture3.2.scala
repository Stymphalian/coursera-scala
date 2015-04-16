// package jordan // can't do this inside the REPL
// import week3.Rational
// import week3.{Rational,Hello}
// import week3._
// www.scala-lang.org/api/current


// Like an interface
trait Planar {
    def height:Int
    def width:Int
    def surface = height*width
}

// class Square extends Shape with Planar with Movable..
// Scala.Any
// Scala.AnyVal - Double, Float
// Scala.AnyRef (java.lang.Object)
//      scala.ScalaObject

// subclasses of all types
// Scala.Nothing - subtype of all AnyVal
// Scala.Null  - subtype of all AnyRef

// Any  == ,!=, equals, hashCode, toString
// AnyRef = base type of all reference types
    // alias of java.lang.Object
// AnyVal - the base type of all primitive types..

// Nothing type. - subclass of
// throw Exc
def error(msg:String) = {
    throw new Error(msg)
}
error("WHY!")
val x = null;
val y : String = x

if( true) 1 else false