package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    
    val setPositiveNumbers = union(singletonSet(1), singletonSet(300))
    val setNegativeNumbers = union(singletonSet(-10), singletonSet(-99))
    val setPositiveAndNegativeNumbers = union(setPositiveNumbers, setNegativeNumbers)
    val setEvenNumbers = union(singletonSet(4), singletonSet(6))
    val setOddNumbers = union(singletonSet(3), singletonSet(9))
    val setEvenAndOddNumbers = union(setEvenNumbers, setOddNumbers)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
//  ignore("singletonSet(1) contains 1") {
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
      assert(!contains(s1, 2), "Singleton")
    }
  }

//  ignore("union contains all elements") {
  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  //  ignore("union contains all elements") {
  test("intersection of elements") {
    new TestSets {      
      val s = union(s1, s2)
      val t = union(s1, s3)
      val r = intersect(s,t)
      val u = intersect(s,s1)
      assert(contains(r, 1), "intersect 1")
      assert(!contains(r, 2), "intersect 2")
      assert(!contains(r, 3), "intersect 3")
      assert(contains(u, 1), "intersect u 1")
      assert(!contains(u, 2), "intersect u 2")
    }
  }
  
    test("diff of elements") {
    new TestSets {      
      val s = union(s1, s2)
      val t = union(s1, s3)
      val r = diff(s,t)
      val u = diff(s,s3)
      assert(!contains(r, 1), "diff 1")
      assert(contains(r, 2), "diff 2")
      assert(!contains(r, 3), "diff 3")      
      
      assert(contains(u, 1), "diff 1")
      assert(contains(u, 2), "diff 2")
      assert(!contains(u, 3), "diff 3")
    }
    }
        
   test("filter of elements") {
    new TestSets {      
      val s = union(s1, s2)
      val t = union(s1, s3)
      val r = filter(s,t)
      val u = filter(s,s1)
      assert(contains(r, 1), "intersect 1")
      assert(!contains(r, 2), "intersect 2")
      assert(!contains(r, 3), "intersect 3")
      assert(contains(u, 1), "intersect u 1")
      assert(!contains(u, 2), "intersect u 2")
    }
  }
   
   
  test("forall of elements") {
    new TestSets {      
      val s = union(s1, s2)
      val t = union(s,s3)
      assert(forall(t, (x)=>true), "forall 1")      
      assert(!forall(t, (x)=>false), "forall 2")    
      assert(forall(t, (x)=>(x == 1 || x == 2 || x == 3)), "forall 3")
      assert(!forall(t, (x)=>(x == 1 || x == 2 )), "forall 4")
      
      val u = union(singletonSet(-1000),singletonSet(1000))
      val v = union(singletonSet(-1000),singletonSet(1001))
      assert(forall(u, (x)=>true), "forall 5")
      assert(forall(v, (x)=>true), "forall 6")
      
      
      assert(forall(setPositiveNumbers, {elem:Int => elem > 0}))
      assert(forall(setNegativeNumbers, {elem:Int => elem < 0}))
      assert(!forall(setPositiveAndNegativeNumbers, {elem:Int => elem < 0}))
      assert(forall(setEvenNumbers, {elem:Int => (elem % 2) == 0}))
      assert(forall(setOddNumbers, {elem:Int => (elem % 2) != 0}))
      assert(!forall(setEvenAndOddNumbers, {elem:Int => (elem % 2) == 0}))
      
    }
  }
  
  test("exist element") {
    new TestSets {      
      val s = union(s1, s2)
      val t = union(s,s3)
      assert(exists(t, (x)=> x == 1), "exist 1")      
      assert(exists(t, (x)=> x == 3), "exist 3")    
      assert(!exists(t, (x)=> x == 4), "exist 4")      
    }
  }
  
  test("map tests") {
    new TestSets {      
      val s = union(s1, s2)
      val t = union(s,s3)
      val u = map(t, x=> 10*x)
      
      assert(!contains(u,1), "map 1")
      assert(contains(u,10), "map 10")
      assert(contains(u,20), "map 20")
      assert(contains(u,30), "map 30")
      assert(!contains(u,40), "map 40")
    }
  }
  
  
  
}
