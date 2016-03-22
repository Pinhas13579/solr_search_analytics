package demo

import play.api.libs.json.{JsValue, Json}

import scala.io.Source

/**
  * Created by pppp on 3/13/16.
  */
class Person(nameF2: String, nameL2: String, email2: Option[Double] = None){
  var nameF: String = nameF2
  var nameL: String = nameL2
  var email: Option[Double] = email2

  def getEmail() = email
}

object New2 extends App {


  /*val x = 5
  val monad: Option[Int] = Some(x)
  val result = monad.flatMap(x => Option(Some(x) == monad))

  println(result)
*/

  var q = Some(10.0)
  // var q = None

  val p1 = {
    new Person("a", "aa", q)
  }

  println(p1.nameF)
  println(p1.nameL)
  println(p1.email.getOrElse(None))



  val qwe = List(("C", "B", 1), ("C", "D", 1), ("E", "F", 1), ("C", "D", 2), ("G", "H", 1), ("A", "H", 1))
  var asd = qwe find {e => e._1 == "A"}
  //drop
  println(asd)
  println(qwe.filterNot(_._1 == "G"))




  // We are enthusiastic about newcomers
  def hello(name: Option[String]) = s"Hello, ${name getOrElse "stranger" toUpperCase}!"

  def a(name: String) = println( hello(Option(name)) )

  def b(name: String) = println( hello(Some(name)) )


  a(null)

  b("QQQQQ")






}
