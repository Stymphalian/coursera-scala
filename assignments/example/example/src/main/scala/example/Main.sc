
import example._

object Main {
  println(example.Lists.max(List(1,3,2)))         //> scala.NotImplementedError: an implementation is missing
                                                  //| 	at scala.Predef$.$qmark$qmark$qmark(Predef.scala:225)
                                                  //| 	at example.Lists$.max(Lists.scala:41)
                                                  //| 	at Main$$anonfun$main$1.apply$mcV$sp(Main.scala:5)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at Main$.main(Main.scala:4)
                                                  //| 	at Main.main(Main.scala)
}