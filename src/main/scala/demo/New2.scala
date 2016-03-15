package demo

import play.api.libs.json.{JsValue, Json}

import scala.io.Source

/**
  * Created by pppp on 3/13/16.
  */
object New2 extends App {

  // 1
  // val url = "http://api.geonames.org/postalCodeLookupJSON?postalcode=6600&country=AT&username=demo"
  // myJSON.setMyJsonUrl(url)

  // abcdef.json
  val file2: String = "data/abcdef.json"
  // val myJSON_abcdef: MyJSON = new MyJSON {}
  // myJSON_abcdef.setMyJson(file2, "file")


  //2
  var myJSONS: JsValue = Json.parse(Source.fromFile(file2).getLines.mkString)

  // 3
  val jsonItemS = (myJSONS \\ "items")
  // val tempItemArr = Array.ofDim[Double](jsonItemS.length, listFeature.length)
  var ii: Int = 0
  println(jsonItemS.length)

  jsonItemS.foreach {
    // ii = 0
    item => println(item)
      /*
      for (jj <- 0 to listFeature.length - 1) {
        try {
          tempItemArr(ii)(jj) = (item \ "mlr_features" \ listFeature(jj)).toString().toDouble
        }
        catch {
          case e1: NumberFormatException => tempItemArr(ii)(jj) = Double.MaxValue
          // case e2: ArrayIndexOutOfBoundsException => println("!!! - " + ii + " - " + jj)
        } // try {
      } // for (jj <- 0 to listFeatureForAbcdef.length - 1) {
      ii += 1
      */
  } // str_json_abcdef_previousItem.foreach {


}
