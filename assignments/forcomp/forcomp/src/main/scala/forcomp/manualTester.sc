package forcomp

object manualTester {
  val word ="jorrdan"                             //> word  : String = jorrdan
  Anagrams.wordOccurrences(word)                  //> res0: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (j,1), (n,1), (o,1), 
                                                  //| (r,2))
  Anagrams.wordOccurrences("crysastal")           //> res1: forcomp.Anagrams.Occurrences = List((a,2), (c,1), (l,1), (r,1), (s,2),
                                                  //|  (t,1), (y,1))
  Anagrams.wordOccurrences("jjjorda")             //> res2: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (j,3), (o,1), (r,1))
                                                  //| 
  (word.toLowerCase().toList.groupBy( x => x) map ( x => (x._1,x._2.length))).toList
                                                  //> res3: List[(Char, Int)] = List((n,1), (j,1), (a,1), (r,2), (o,1), (d,1))
                     
                     
	val p = Anagrams.dictionaryByOccurrences  //> p  : Map[forcomp.Anagrams.Occurrences,List[forcomp.Anagrams.Word]] = Map(Lis
                                                  //| t((e,1), (i,1), (l,1), (r,1), (t,2)) -> List(litter), List((a,1), (d,1), (e,
                                                  //| 1), (g,2), (l,1), (r,1)) -> List(gargled), List((a,1), (e,1), (h,1), (i,1), 
                                                  //| (k,1), (n,1), (s,3)) -> List(shakiness), List((e,2), (g,1), (n,1)) -> List(g
                                                  //| ene), List((a,2), (n,1), (t,1), (y,1)) -> List(Tanya), List((a,1), (d,1), (e
                                                  //| ,2), (h,1), (m,1), (n,2), (o,1), (s,3)) -> List(handsomeness), List((a,2), (
                                                  //| c,1), (e,2), (k,1), (l,1), (m,1), (p,1), (r,1), (t,1)) -> List(marketplace),
                                                  //|  List((a,1), (i,1), (l,2), (s,1), (v,1)) -> List(villas), List((d,2), (e,1),
                                                  //|  (h,2), (n,1), (r,1), (t,1), (u,1)) -> List(hundredth), List((a,3), (b,1), (
                                                  //| c,1), (h,1), (i,2), (l,1), (o,1), (p,2), (r,1), (t,1), (y,1)) -> List(approa
                                                  //| chability), List((d,1), (e,2), (l,1), (s,1), (t,2)) -> List(settled), List((
                                                  //| a,1), (g,1), (i,3), (l,1), (n,2), (t,1), (z,1)) -> List(Latinizing), List((a
                                                  //| ,1), (m,1), (n,1), (o,3)
                                                  //| Output exceeds cutoff limit.

	val d = p(List(('a', 1), ('e', 1), ('t', 1)))
                                                  //> d  : List[forcomp.Anagrams.Word] = List(ate, eat, tea)
                                                  
	val e = Anagrams.wordAnagrams("ate")      //> e  : List[forcomp.Anagrams.Word] = List(ate, eat, tea)
	
	val a = List(1,2,3)                       //> a  : List[Int] = List(1, 2, 3)
	val b = List(4,5,6)                       //> b  : List[Int] = List(4, 5, 6)
	val c = a ++ b                            //> c  : List[Int] = List(1, 2, 3, 4, 5, 6)
	
	val f = List((1,1),(2,2),(3,3))           //> f  : List[(Int, Int)] = List((1,1), (2,2), (3,3))
	f.toMap.foldLeft(Map()){(acc,x) => acc}   //> res4: scala.collection.immutable.Map[Nothing,Nothing] = Map()


	for {
		a <- Anagrams.combinations(Anagrams.wordOccurrences("linux"))
		p <- Anagrams.dictionaryByOccurrences(a)
	}yield p                                  //> res5: List[forcomp.Anagrams.Word] = List(Linux, Lin, nil, Unix, in, nu)
	//Anagrams.sentenceAnagrams(List("Linux", "rulez"))
	
	
	//Anagrams.sentenceAnagrams(List("Yes", "man"))
	
}