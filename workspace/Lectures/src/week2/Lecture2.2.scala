package week2
object lecture22 {
    // def sum(f:Int => Int): (Int,Int) => Int = {
    def sum(f:Int => Int)(a:Int,b:Int):Int = {
        if( a >b) 0 else f(a) + sum(f)(a+1,b)
    }

    // def product(a:Int,b:Int):Int = {
    //     if(a > b) 1 else a*product(a+1,b)
    // }

    def product(f:Int => Int)(a:Int, b:Int):Int = {
        if( a > b) 1
        else f(a) * product(f)(a+1,b)
    }

    def factorial(n:Int):Int = {
        product(x =>x)(1, n)
    }

    // def genOp(f:(Int,Int) => Int)(a:Int,b:Int):Int = {
    //     if( a >= b) b
    //     else f(a,genOp(f)(a+1,b))
    // }

    def mapReduce(f:Int => Int, op:(Int,Int)=>Int, zero:Int)(a:Int,b:Int):Int =
    {
        if( a > b) zero
        else op(f(a), mapReduce(f,op,zero)(a+1,b))
    }

}