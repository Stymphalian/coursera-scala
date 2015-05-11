package streams

object manualTester {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def terrainFunction(levelVector: Vector[Vector[Char]]): (Int,Int) => Boolean = {
  	val x_size = levelVector.length
    val y_size = if (x_size == 0) -1 else levelVector(0).length
    return (x:Int,y:Int) => {
      if( x < 0 || x >= x_size) false
      else if( y < 0 || y >= y_size) false
     	else levelVector(x)(y) != '-'
    }
  }                                               //> terrainFunction: (levelVector: Vector[Vector[Char]])(Int, Int) => Boolean

	 val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin                  //> level  : String = ooo-------
                                                  //| oSoooo----
                                                  //| ooooooooo-
                                                  //| -ooooooooo
                                                  //| -----ooToo
                                                  //| ------ooo-
	 val t = Vector(level.split("\n").map(str => Vector(str: _*)): _*)
                                                  //> t  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Cha
                                                  //| r]] = Vector(Vector(o, o, o, -, -, -, -, -, -, -), Vector(o, S, o, o, o, o, 
                                                  //| -, -, -, -), Vector(o, o, o, o, o, o, o, o, o, -), Vector(-, o, o, o, o, o, 
                                                  //| o, o, o, o), Vector(-, -, -, -, -, o, o, T, o, o), Vector(-, -, -, -, -, -, 
                                                  //| o, o, o, -))
	 t.length                                 //> res0: Int = 6
	 t(0).length                              //> res1: Int = 10
   val terrain = terrainFunction(Vector(level.split("\n").map(str => Vector(str: _*)): _*))
                                                  //> terrain  : (Int, Int) => Boolean = <function2>
  
   terrain(-1,0)                                  //> res2: Boolean = false
   
   terrain(0,0)                                   //> res3: Boolean = true
   terrain(0,1)                                   //> res4: Boolean = true
   terrain(0,2)                                   //> res5: Boolean = true
   terrain(0,3)                                   //> res6: Boolean = false
   terrain(0,4)                                   //> res7: Boolean = false
   terrain(0,5)                                   //> res8: Boolean = false
   terrain(0,6)                                   //> res9: Boolean = false
   terrain(0,7)                                   //> res10: Boolean = false
   terrain(0,8)                                   //> res11: Boolean = false
   terrain(0,9)                                   //> res12: Boolean = false
   
   terrain(1,0)                                   //> res13: Boolean = true
   terrain(1,1)                                   //> res14: Boolean = true
   terrain(1,2)                                   //> res15: Boolean = true
   terrain(1,3)                                   //> res16: Boolean = true
   terrain(1,4)                                   //> res17: Boolean = true
   terrain(1,5)                                   //> res18: Boolean = true
   terrain(1,6)                                   //> res19: Boolean = false
   terrain(1,7)                                   //> res20: Boolean = false
   terrain(1,8)                                   //> res21: Boolean = false
   terrain(1,9)                                   //> res22: Boolean = false

   terrain(5,0)                                   //> res23: Boolean = false
   terrain(5,1)                                   //> res24: Boolean = false
   terrain(5,2)                                   //> res25: Boolean = false
   terrain(5,3)                                   //> res26: Boolean = false
   terrain(5,4)                                   //> res27: Boolean = false
   terrain(5,5)                                   //> res28: Boolean = false
   terrain(5,6)                                   //> res29: Boolean = true
   terrain(5,7)                                   //> res30: Boolean = true
   terrain(5,8)                                   //> res31: Boolean = true
   terrain(5,9)                                   //> res32: Boolean = false
   
   
	val li =    List(1,2,3)                   //> li  : List[Int] = List(1, 2, 3)
  li.head                                         //> res33: Int = 1
}