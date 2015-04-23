package week2
object leture26{
class Rational(x:Int,y:Int){
    require(y != 0,"denominator must be positive")
    // assert(x>=0)

    // creates a secondadry constructor for the class
    def this(x:Int) = this(x,1)

    private def gcd(a:Int,b:Int):Int = {
        if( b == 0) a
        else gcd(b,a%b)
    }
    def numer = x
    def denom = y

    def less(that:Rational):Boolean = {
        numer*that.denom < that.numer*denom
    }

    def max(that:Rational):Rational = {
        if(this.less(that)) that else this
    }

    def add(that:Rational) = {
        new Rational(
            numer*that.denom + that.numer*denom,
            denom*that.denom
            )
    }

    def sub(that:Rational) = {
        add(that.neg())
    }

    def neg():Rational = {
        new Rational(-numer,denom)
    }

    override def toString() = {
        val g = gcd(x,y)
        numer/g + "/" + denom/g
    }
}

val x = new Rational(1,2)
val y = new Rational(5,7)
val z = new Rational(3,2)
x.numer
x.denom
x.sub(y).sub(z)
y.add(y)
x.less(y)
x.max(y)
// val strange = new Rational(1,0)
// strange.add(strange)
new Rational(2)
}