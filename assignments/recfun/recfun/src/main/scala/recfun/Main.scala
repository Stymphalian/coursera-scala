package recfun
import common._

object Main {
  def main(args: Array[String]) {
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(pascal(col, row) + " ")
//      println()
//    }
    
    println(countChange(4,List(1,2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if( c < 0 || c > r) 0    
    else if( r == 0 ) 1    
    else pascal(c-1,r-1) + pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def inner(chars:List[Char],c:Int):Boolean = {
      if( chars.isEmpty ) (c == 0)
      else {
        if( chars.head == '(')
          inner(chars.tail, c + 1)
        else if(chars.head == ')')
          if(c > 0 ) inner(chars.tail, c - 1) 
          else false          
        else
          inner(chars.tail,c)        
      }      
    }
    inner(chars,0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {    
     
    if( money < 0 ){
      //println(money,coins,"< 0")
      0
    } 
    else if(money == 0) {
      //println(money,coins," == 0")
      1
    } 
    else if(coins.isEmpty){
       //println(money,coins,"empty")
       0
    }else {
      countChange(money,coins.tail) + 
      countChange(money - coins.head, coins)
      
//      //println(money,coins)
//      countChnage(money - p, coins)
//      var sum_count = 0      
//      var p = 0
//      while( money - p >= 0) { 
//        sum_count += countChange(money - p,coins.tail)
//        p += coins.head
//      } 
//      return sum_count      
    } 
  }
}
