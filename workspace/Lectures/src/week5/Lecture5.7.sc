package week5

object Lecture57 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // prove the following distrubution law for map over concatenation
// for any list xs, ys, and function f
// (xs ++ ys) map f = (xs map f) ++  (ys map f)

// ++ clauses
// Nil ++ ys  = ys
// (x :: xs1 ) ++ ys = x :: ( xs1 ++ ys)

// map clause
// Nil map f = Nil
// (x :: xs) map f =  f(x) :: ( xs map f)

// ----------------------------------------

// Base Case 1
// xs = Nil
// ys = Nil

// (Nil ++ Nil) map f = (Nil map f) ++ (Nil map f)
// LHS
// (Nil ++ Nil) map f
// Nil map f           // by ++ clause 1
// Nil                 // by map clause 1

// RHS
// (Nil map f) ++ (Nil map f)
// Nil ++ (Nil map f)          // by map clause 1
// Nil ++ Nil                  // by map clause 1
// Nil                         // by ++ clause 1

// Base Case 2 and 3
// xs = Nil        or ys
// ys                 xs = Nil
// (xs ++ Nil) map f = (xs map f) ++ (Nil map f)
// RHS
// (xs ++ Nil) map f
// xs map f                    // by ++ clause 1

// LHS
// (xs map f) ++ ( Nil map f)
// (xs map f) ++ Nil               // by map clause 1
// (xs map f)                      // by ++ clause 1

// Inductive Hypthesis:
// (xs ++ ys) map f = (xs map f) ++  (ys map f)


// Inductive Step Case 1
// ((x :: xs) ++ ys) map f = ( (x :: xs) map f) ++ ( ys map f)
// LHS
// ((x :: xs) ++ ys) map f
// (x :: (xs ++ ys)) map f          // by ++ clause 2
// f(x) :: ((xs ++ ys) map f)     // by map clause 2
// f(x) :: ((xs map f) ++ (ys map f)) // by IH
// (f(x) :: (xs map f)) ++ (ys map f) // by ++ clause 2
// ((x :: xs) map f) ++ (ys map f)     // by map clause 2


// RHS
// ((x :: xs) map f) ++ (ys map f)
// (f(x) :: (xs map f)) ++ (ys map f)      // by map clause 2
// f(x) ::((xs map f) ++ ( ys map f))     // by ++ clause 2
// f(x) :: ((xs ++ ys) map f)             // by inductive hypothisis
// (x :: (xs ++ ys)) map f                // by map clause 2
// ((x :: xs) ++ ys) map f                // by ++ clause 2


// Inductive Step Case 2
// (x :: xs) ++ (y :: ys)) map f = ((x :: xs) map f) ++ ( (y :: ys) map f)

// LHS
// (x :: xs) ++ ( y :: ys) map f
// (x :: xs) ++ zs map             // let zs = ( y :: ys)
// ((x :: xs) map f) ++ (zs map f) // by Inductive Step Case 1
// (( x :: xs) map f) ++ ((y :: ys) map f) //expand zs


// RHS
// ((x :: xs) map f) ++ ( (y :: ys) map f)
// ((x :: xs) map f) ++ ( zs map f)            // let zs  = (y :: ys)
// ((x :: xs) ++ ys) map f                     // by inducutive Step Case 1
// ((x :: xs) ++ ( y :: ys)) map f            // expand zs


// Conclusion
// By the IH, we have proven by induction the two inductive steps.
  
  
}