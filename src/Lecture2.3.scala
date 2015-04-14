import math.abs

object ex {
    val tolerance = 0.0001

    def isCloseEnough(x:Double,y:Double) =
        abs((x-y)/x)/x < tolerance

    def fixedPoint(f :Double => Double)(firstGuess :Double) = {
        def iterate(guess:Double):Double = {
            val next = f(guess)
            if(isCloseEnough(guess,next)) next
            else iterate(next)
        }
        iterate(firstGuess)
    }

    def avgDamp(f:Double => Double)(x:Double) = (x + f(x))/2
    // def sqrt(x:Double):Double = fixedPoint(y => (y + x/y)/2)(1.0)
    def sqrt(x:Double):Double = fixedPoint(avgDamp(w => x/w)) (1.0)
}

ex.fixedPoint( x => 1 + x/2)(1)
ex.sqrt(2)