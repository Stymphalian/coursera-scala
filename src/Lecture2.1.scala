def sum(f:Int => Int,a:Int,b:Int):Int = {
    if( a > b) 0
    else f(a) + sum(f,a+1,b)
}

def sumTwice(a:Int,b:Int) = sum( x => x*2,a,b)
def sumCube(a:Int,b:Int) = sum( x => x*x*x,a,b)

def sumTail(f:Int => Int,a :Int, b:Int): Int = {
    def _f(accum:Int, a:Int):Int = {
        if( a > b) accum
        else _f(accum + f(a),a +1)
    }
    _f(0,a)
}