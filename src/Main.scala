object session{
    def abs(x :Double) = if( x < 0) -x else x

    def sqrt(x:Double) = {
        def sqrtIter(guess:Double): Double =
        if(isGoodEnough(guess))
            guess
        else
            sqrtIter(improve(guess))

        def isGoodEnough(guess:Double) =
            abs(guess*guess - x)/x < 0.001

        def improve(guess:Double) =
            (guess + x/guess)/2

        sqrtIter(1.0)
    }
}

session.sqrt(2.0)
session.sqrt(4.0)

def gcd(a:Int, b:Int):Int =
    if (b == 0) a else gcd(b, a % b)

def factorial(n:Int):Int =
    if(n == 0) 1 else n*factorial(n-1)

// Tail recursive factorial
def factorial(n:Int):Int = {
    def _f(n:Int,carry:Int):Int =
        if( n == 0) carry else _f(n-1,carry*n)
    _f(n,1)
}
