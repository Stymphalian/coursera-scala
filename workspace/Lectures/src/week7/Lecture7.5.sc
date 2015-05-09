package week7

object Lecture75 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  val problem = new Pouring ( Vector(4,9,19))     //> problem  : week7.Pouring = week7.Pouring@6537cf78
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with w
                                                  //| eek7.Lecture75.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0),
                                                  //|  Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Po
                                                  //| ur(2,1))
	//problem.pathSets.take(3).toList
 	problem.solutions(6)                      //> res1: Stream[week7.Lecture75.problem.Path] = Stream(Fill(2) Pour(2,0) Pour(2
                                                  //| ,1)--> Vector(4, 9, 6), ?)
}