// functional decomponsitoin with pattern mathcing

trait Expr
case class Number(n:Int) extends Expr {}
case class Sum(e1:Expr,e2:Expr) extends Expr{}
case class Prod(e1:Expr,e2:Expr) extends Expr{}
case class Var(n:String) extends Expr{}

// {
//     def eval:Int = this match {
//         case Number(n) => n
//         case Sum(e1,e2)=> e1.eval + e2.eval
//     }
// }
// case class Number(n:Int) extends Expr
// case class Sum(e1:Epxr,e2:Expr) extends Expr

val N = 50
def eval(e:Expr):Int = e match {
    case Number(n) => n
    case Sum(e1,e2) => eval(e1) + eval(e2)
    // case Prod(e1,e2) => eval(e1) + eval(e2)
    // case Var(e1,e2) => eval(e1) + eval(e2)
    // case _ -> throw new Error("Umatched pattern")
}

def show(e:Expr):String = {
    e match {
        case Number(n) => n.toString()
        case Sum(e1,e2) => show(e1) + " + " + show(e2)
        case Var(n) => n
        case Prod(e1,e2) => {
            val e3 = e1 match {
                case Sum(_,_) => "(" + show(e1) + ")"
                case _ => show(e1)
            }
            val e4 = e2 match {
                case Sum(_,_) => "(" + show(e2) + ")"
                case _ => show(e2)
            }
            e3 + " * " + e4
        }
    }
}

// variables u
// CONSTANTS
// object Number{
//     def apply(n:Int) = new Number(1)
// }
// e match { case p1 => e1 ... case pn => en}
// epxression problem
