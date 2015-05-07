package week7

object Lecture71 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // proof of completness of trees
  // Empty contains x
  // (x incl x) contains x = true
  // (s incl x) contains y = s contains y   if x != y
  
  // proposition 1
  // true be default
  
  // ( s incl x) contains x
  // Base case empty
  // (Empty incl x) contains x
  // NonEmpty(x, Empty,Empty) contains x
  // true
  // Therefore our IH is
  // (s incl x ) contains x ==> true
  
  //NonEmpty(x, l, r)
  // x == x
  // NonEmpty(x,l,r) incl x ) contains x
  // NonEmpty(x,l,r) contains x
  // true
  
  // z != x
  // NonEmpty(y,l,r) where y < x
  // (NonEmpty(y,l,r) incl x) contains x
  // (NonEmpty(y,l, r incl)) contains x  // by defn of non-empty incl
  // (r incl x) contains x								// by defn of non-empty contains
  // true																// by defn of IH
  
  // NonEmpty(y,l,r) where y >x
  // analagous to the proof where y <x
  
  // if x != y then (xs incl y) contains x = xs contains x
 	// Base Case: Empty ( y < x ).. analagous
 	// (Empty incl y) contains x
 	// NonEmpty(y,Empty,Empty) contains x		// defn of Empty incl
 	// Empty contains x											// by defn of empty contains
 	// false
 	
 	
 	//NonEmpty(z,l,r)
 	// Five Cases
 	// z = x
 	// z = y
 	// z < y < x
 	// y < z < x
 	// y < x < z
 	
 	// z = x,z = y
 	// IS : NonEmpty(x,l,r)
 	// (NonEmpty(x,l,r) incl y) contains x
 	// (NonEmpty(x,l incl y, r) contains x   // non empty incl
 	// True																		// defn of NonEmpty contains
 	// (NonEmpty(x,y,r) contains x)
 	
 	// (NonEmpty(y,l,r) incl y)contains y
 	// NonEmpty(y,l,r) contains y						// again the same
 	
 	// case z < y
 	// NonEmpty(z,l,r) whree z < y < x
 	// (NonEmpty(z,l,r) incl y) contains x , we want to proove (NonEmpty(z,l,r) contains x)
 	// NonEmpty(z,l,r incl y) contains x       // by defn of NonEmpty incl
 	// (r incl y) contains x									// by defn of NonEmpty contains
 	// r contains x														// by IH
 	// NonEmpty(z, l, r) contains x						// by non-empty contains

	// NonEmpty(z,l,r) whre y < z < x
	// NonEmpty(z,l,r) incl y) contains x
	// NonEmptyy(z,l incl y, r) contains x
	// r contains x
	// NonEmpty(z,l,r) contains x
 	  
  // NonEmpty(z,l,r) where y < x < z
  // NonEmpty(z,l,r) incl y ) contains x
  // NonEmpty(z,l incl y, r ) contains x
  // (l incl y) contains x
  // l contains x
  // NonEmpty(z,l,r) contains x
  
  
  
  
  // Empty.incl(x) = NonEmpty(x,Empty,Empty)
  // Empty.contains(x) = false
  // Empty.Union(other) = other
  // NonEmpty(z,l,r).incl(x) = if x == z nothing elseif ( x <z) l incl x else (r incl x)
  // NonEmpty(z,l,r).contains(x) = if x == z true elseif (x <z) l contains x else r contains x
  // NonEmpty(z,l,r).Union(other) = (l union (r union other) ) incl z
  
 	//(xs union ys) contains x  == xs contains x || ys contains x
 	 	
 	// Cases
 	//Base Case
 	// xs = Empty(1), ys = Empty(2)
 	// (Empty(1) union Empty(2) ) contains x
 	// Empty(2) contains x						// by defn of Empty(1) union
 	// ys contains x
 	// ys contains x || xs contains x		//by or intro
 	
 	
	// what tree do you get when you (xs union Empty)?
	// NE(x,l,r) union E
	// l union (r union E)
	// note the recursive
	// two cases
	// r = empty	
	// r = NonEmpty
	// Case 1) r = empty
	// l union ( E union E)
	// l union E
	// Case 1.1) l = Empty
	// 		E Union E => E
	// Case 1.2) l = NonEmpty
	// 		l union E => l2 .. a NE with only the elements of l. Possibly restrutured.
	// Case 2) r = NE
	// l union ( r union E)
	// l union r2  , where r2 contains only the elemtns of r
	// (l.l union (l.r union r2)) incl l.x
	
 	
 	
 	// Note results of (NonEmpty(z,l,r) union Empty)
 	// Base Case
 	// l = Empty,r = Empty
 	// NonEmpty(z,Empty,Empty) union Empty ==> NonEmpty(z,Empty,Empty)
 	// (Empty union ( Empty union Empty)) incl z				// by defn of NonEmpty union
 	// (Empty union Empty ) incl z											// by defn of Empty union
 	// Empty incl z																			// by defn of Empty union
 	// NonEmpty(z, Empty,Empty)												  // by defn of Empty incl
 	
 	// l = NonEmpty(z1,Empty,Empty), r = Empty
 	// NonEmpty(z,NonEmpty(z1,Empty,Empty),Empty) union Empty ==> NonEmpty(z,NonEmpty(z1,Empty,Empty),Empty)
 	// ((NonEmpty(z1,Empty,Empty) union ( Empty union Empty)) incl z	// by defn of nonEmpty union
 	// ((NonEmpty(z1,Empty,Empty) union Empty) incl z									// by defn of Empty union
 	// (NonEmpty(z1,Empty,Empty) incl z															  // by Base Case proof
 	// NonEmpty(z1,Empty, Empty incl z)																// by defn of NonEmpty incl, where z > z1
 	// NonEmpty(z1,Empty,NonEmpty(z,Empty,Empty))											// by defn of Empty incl
 	
 	
 	// NonEmpty(z1,Empty,NonEmpty(z,Empty,Empty)) incl z2											// by defn of Empty incl
 	// z2 == z1 ==> NonEmpty(z1,Empty,NonEmpty(z,Empty,Empty))
 	// z2 < z1  ==> NonEmpty(z1,NonEmpty(z,Empty,Empty),NonEmpty(z,Empty,Empty))
 	// z2 > z1 ==> NonEmpty(z1,Empty,NonEmpty(z,l,r))
 	
 	// l = Empty, r = NonEmpty(z1,Empty,Empty)
 	// NonEmpty(z,Empty,NonEmpty(z1,Empty,Empty)) union Empty
 	// (Empty union (NonEmpty(z1,Empty,Empty) union Empty)) incl z 		// defn of NonEmpty incl
 	// (NonEmpty(z1,Empty,Empty) union Empty) incl z								// def of Empty union
 	// NonEmpty(z1,Empty,Empty) incl z															// by base case proof
 	// NonEmpty(z1,Empty incl z,Empty)															// by defn of NonEmpty incl
 	// NonEmpty(z1,NonEmpty(z,Empty,Empty),Empty)										// by defn of Empty incl
 	
 	// NonEmpty(z1,Nonempty(z,Empty,Empty),Empty) incl z2											// by defn of Empty incl
 	// z2 == z1 ==> NonEmpty(z1,NonEmpty(z,Empty,Empty),Emty)
 	// z2 < z1  ==> NonEmpty(z1,NonEmpty(z,l,r),Empty))
 	// z2 > z1 ==> NonEmpty(z1,NonEmpty(z,Empty,Empty),NonEmpty(z,Empy,Empty))
 	
 	// l = NonEmpty(z1,l1,r1), r = Empty
 	// NonEmpty(z,NonEmpty(z2,l2,r2), NonEmpty(z3,l3,r3)) union Empty
 	// Note by z2 < z < z3
 	// (NonEmpty(z2,l2,r2) union ( NonEmpty(z3,l3,r3) union Empty) ) incl z
 	// NonEmpty(z2,l2,r2) union
 	
 	
 	// xs = NonEmpty(z1,l1,r1), ys = Empty
 	// (NonEmpty(z1,l1,r1) union Empty) contains x  ==> xs contain x || ys contains x
 	// (l1 union (r1 union Empty) ) incl z) contains x
 	// ((l1 union r1) incl z) contains x		// z by defn, l1 < z < r1
 	//
   
}