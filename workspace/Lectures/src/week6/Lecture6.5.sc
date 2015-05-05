package week6

object Lecture65 {
  	// translation to for expressions
		def mapFun[T,U](xs:List[T],f : T=> U):List[U] = {
			for ( x <- xs) yield f(x)
		}                                 //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
		def flatMapFunc[T,U](xs:List[T], f: T =>Iterable[U]):List[U] = {
			for ( x <- xs; y <- f(x)) yield y
		}                                 //> flatMapFunc: [T, U](xs: List[T], f: T => Iterable[U])List[U]
		def filterFunc[T,U](xs:List[T], f : T=>Boolean): List[T] = {
			for( x <- xs if f(x)) yield x
		}                                 //> filterFunc: [T, U](xs: List[T], f: T => Boolean)List[T]
		
		// in rality the scala comiled epxess for-express in temrs of map, flatMp nad a lazy variant of filter
		// for( x <- e1) yield e2
		// e1.map(x => e2)
		
		
		// for (ex <- e1 if f; s) yield e1
		// for( x <- e1.withFilter(x => f); s) yield e2
		
		// for ( x <- e1; y <- e2; s) yield e3
		// e1.flatMap( x=> for ( y <- e2; s) yield e3)
		
		
		// for ( b <- books; a <- b.authors if a startsWith "Bird") yield b.title
		// books.flatMap( b => for(  a <- b.authors if a startsWith "Bird") yield b.title) )
		// books.flatMap( b => for(  a <- b.authors.withFilter( a => a startsWith "Bird")) yield b.title) )
		// books.flatMap( b => b.authors.withFilter( a => a startsWith "Bird") map ( y => y.title) )
		
}