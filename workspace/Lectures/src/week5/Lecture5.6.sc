package week5

object Lecture56 {
  // strutural induction on lists
  //P(xs)
  //show that P(Nil) holds (base case)
  //for a list xs and some element x, show the induction step:
  //	if( P(xs) holds then P(x :: xs) also holds
  
  // prove x :: Nil = xs
  // base case
  // Nil ++ Nil => Nil
  // = Nil by first clause
  
  // induction step
  // (x :: xs) ++ Nil => (x :: xs)
  // = x :: ( xs ++ Nil)  // by clause 2
  // = x :: xs 						// by induction hypothesis
  // [x]
  
  
  // natural induction
  // referential  transparency
  println("Hello world")                          //> Hello world
}