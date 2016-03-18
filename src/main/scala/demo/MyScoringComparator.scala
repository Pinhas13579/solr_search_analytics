package demo

import play.api.libs.json.{Json, JsValue}

import scala.io.Source

/**
  * Created by PPPP on 3/17/2016.
  */
class MyScoringComparator {

  var listFeatureReturn: List[MySignal] = Nil

  def parseStreamFirst(str: String, typeJSON: String, itemStr: String, listFeatureFor_abcdef: List[String]): List[MySignalPerItem] = {

    var myListS: List[MySignalPerItem] = Nil // Result!!!!!!!!!!!!!

    var myJSONS1: JsValue = null

    typeJSON match {
      case "file" => myJSONS1 = Json.parse(Source.fromFile(str).getLines.mkString)
      case "url" => myJSONS1 = Json.parse(Source.fromURL(str).mkString)
    }

    // var items: Seq[JsValue] = (myJSONS1 \ "items" \\ itemStr)
    var str_signals: List[MySignal] = null

    (myJSONS1 \ "items" \\ itemStr).foreach {
      i => println(i)
        str_signals = new MyScoringComparator().parseStreamSecond(i, listFeatureFor_abcdef)
        myListS = myListS ::: List(new MySignalPerItem((i \ "item_id").toString(), (i \ "reranked_final_score").toString(), str_signals))
    }

    return myListS
  }

  def parseStreamSecond(json: JsValue, listFeature: List[String]): List[MySignal] = {

    var mlr_features: Double = 0
    var mlr_weights: Double = 0

    listFeature.foreach {
      lf => //
        try {
          mlr_features = (json \ "mlr_features" \ lf.toString).toString().toDouble
        }
        catch {
          case e1: NumberFormatException => mlr_features = Double.MaxValue
          // case e2: ArrayIndexOutOfBoundsException => println(lf)
        } // try {
        try {
          mlr_weights = (json \ "mlr_weights" \ lf.toString).toString().toDouble
        }
        catch {
          case e1: NumberFormatException => mlr_weights = Double.MaxValue
          // case e2: ArrayIndexOutOfBoundsException => println(lf)
        } // try {

        listFeatureReturn = listFeatureReturn ::: List(new MySignal((lf.toString), (mlr_features), (mlr_weights)))
    } // listFeature.foreach{

    return listFeatureReturn
  } // def parseStream(json: JsValue, listFeature:List[String]): List[MySignal] = {

} // class MyScoringComparator {