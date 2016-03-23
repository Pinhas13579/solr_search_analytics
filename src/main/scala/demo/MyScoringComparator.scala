package demo

import java.io.Serializable
import play.api.libs.json.{Json, JsValue}
import scala.io.Source

/**
  * Created by PPPP on 3/17/2016.
  */
class MyScoringComparator(val file: String, val typeJSON: String, val itemParse: String, val listFeatureS: List[String]) {

  private val myList: List[MySignalPerItem] = parseStream()

  def getMyList(): List[MySignalPerItem] = myList


  def myCalcPrecentage(myList2: List[MySignalPerItem], strType: Option[String]): List[MySignalPerItem] = {

    /*
    if (!strType.isEmpty){ // OR (strType.isDefined)
      if ( (strType.getOrElse(None).toString.equalsIgnoreCase("latest")) || (strType.getOrElse(None).toString.equalsIgnoreCase("old")) )
       println("werwere")
    }
    */

    var myListReturn: List[MySignalPerItem] = Nil // Result!!!!!!!!!!!!!

    var myListTemp: List[MySignalPerItem] = myList2
    var myListTemp2: List[MySignalPerItem] = null

    // precentage = ((old score - new score) / old score) || ((previousItem - latestItem) / previousItem)
    // latestItem - new score
    var itemId1: String = null
    var rerankedFinalScore1: Serializable = None
    var signals1: List[MySignal] = Nil
    var result1: Serializable = None
    // previousItem - old score
    // var itemId2: String = itemId1
    var rerankedFinalScore2: Serializable = None
    var signals2: List[MySignal] = Nil
    var result2: Serializable = None
    // temp
    var rerankedFinalScor_temp: Option[String] = None
    var signals_temp: List[MySignal] = Nil
    var precentage_temp: Option[Number] = None

    // myList
    myList.foreach { ml =>
      // null
      signals_temp = Nil
      rerankedFinalScore1 = None
      rerankedFinalScore2 = None
      rerankedFinalScor_temp = None

      // first - previousItem
      itemId1 = ml.getItemId()
      rerankedFinalScore1 = ml.getRerankedFinalScore()
      signals1 = ml.getSignals()

      // second - latestItem
      myListTemp2 = myListTemp.filter(_.getItemId() == itemId1)

      // 1 - if found itemId1 in List of old - recentage_temp
      if (myListTemp2.length != 0) {
        // result - rerankedFinalScore
        rerankedFinalScore2 = myListTemp2.head.getRerankedFinalScore()
        rerankedFinalScor_temp = Some(rerankedFinalScore1 + "-" + rerankedFinalScore2)

        // result - signals
        signals2 = myListTemp2.head.getSignals()

        // for - listFeatureS of List of new - signals1
        signals1.foreach { lf =>
          // latestItem - new score
          result1 = None
          // result1 = signals1.filter(_.getKey() == lf).head.getResult()
          result1 = lf.getResult()
          // println(result1)

          // previousItem - old score
          result2 = None
          result2 = signals2.filter(_.getKey() == lf.getKey()).head.getResult()
          // println(result2)

          // precentage_temp
          // 1 - if previousItem and latestItem have
          if (result1 != None && result2 != None)
            // NaN or Double.MaxValue
            if (result2.toString.toDouble == 0.0 )
              precentage_temp = Some(Double.MaxValue)
            else
              // precentage = ((old score - new score) / old score) || ((previousItem - latestItem) / previousItem)
              precentage_temp = Some( (result2.toString.toDouble - result1.toString.toDouble) / result2.toString.toDouble )
          // 2 - if previousItem has and latestItem does't have
          else if (result1 != None && result2 == None)
            precentage_temp = None
          // 3 - if previousItem does't have and latestItem has
          else if (result1 == None && result2 != None)
            precentage_temp = None
          // 4 - if previousItem does't have and latestItem does't have
          else if (result1 == None && result2 == None)
            precentage_temp = None

          // add signals
          //signals_temp = signals_temp ::: List(new MySignal(lf, score_temp, weight_temp, result_temp, precentage_temp))
          signals_temp = signals_temp ::: List(new MySignal(lf.getKey(),
            if (lf.getScore()==None) None else Some(lf.getScore().toString.toDouble),   // score
            if (lf.getWeight()==None) None else Some(lf.getWeight().toString.toDouble), // weight
            if (lf.getResult()==None) None else Some(lf.getResult().toString.toDouble), // result
            precentage_temp))
        } // signals1.foreach { lf =>
      } // if (myListTemp1.length != 0) {
        // 2 - if don't find itemId1 in List of latestItem - recentage_temp = None
      else {
        // for - listFeatureS = signals1
        rerankedFinalScor_temp = Some(rerankedFinalScore1 + "-" + None)
        signals_temp = signals1
      } // if (myListTemp1.length != 0) {

      // add myListReturn
      myListReturn = myListReturn ::: List(new MySignalPerItem(itemId1, rerankedFinalScor_temp, signals_temp))

      // delete item
      myListTemp = myListTemp.filterNot(_.getItemId() == itemId1)
    } // myList.foreach{  ml =>

    // if stay List of latestItem
    myListTemp.foreach{ ml =>
      myListReturn = myListReturn ::: List(new MySignalPerItem(ml.getItemId(), Some(None + "-" + ml.getRerankedFinalScore()), ml.getSignals()))
    } // myListTemp.foreach{ ml =>


    myListReturn
  } // def myCalcPrecentage(myList2: List[MySignalPerItem]): List[MySignalPerItem] = {

  def parseStream(): List[MySignalPerItem] = {

    var myListS: List[MySignalPerItem] = Nil // Result!!!!!!!!!!!!!

    var myJSONS1: JsValue = null

    typeJSON match {
      case "file" => myJSONS1 = Json.parse(Source.fromFile(file).getLines.mkString)
      case "url" => myJSONS1 = Json.parse(Source.fromURL(file).mkString)
    }

    var str_signals: List[MySignal] = null
    var ss: String = null
    var dd: Option[String] = None

    (myJSONS1 \ "items" \\ itemParse).foreach { i =>
      str_signals = parseStreamSecond(i)

      dd = None
      try {
        ss = (i \ "reranked_final_score").toString()
        dd = Some(ss.substring(1, ss.length - 1)) // dd = Some(ss.substring(1, ss.length - 1).toDouble)
      }
      catch {
        case e1: NumberFormatException => dd = None // println("ERROR!!!!!")
      }

      myListS = myListS ::: List(new MySignalPerItem((i \ "item_id").toString(), dd, str_signals))
    } // (myJSONS1 \ "items" \\ itemParse).foreach { i =>

    myListS // return
  } // def parseStreamFirst(): List[MySignalPerItem] = {

  def parseStreamSecond(json: JsValue): List[MySignal] = {

    var listFeatureReturn: List[MySignal] = Nil

    var mlr_score: Option[Number] = None
    var mlr_weights: Option[Number] = None
    var result: Option[Number] = None

    listFeatureS.foreach { lf =>
      mlr_score = None
      try {
        mlr_score = Some((json \ "mlr_features" \ lf.toString).toString().toDouble)
      }
      catch {
        case e1: NumberFormatException => mlr_score = None // Some(Double.MaxValue)
        // case e2: ArrayIndexOutOfBoundsException => println(lf)
      } // try {

      mlr_weights = None
      try {
        mlr_weights = Some((json \ "mlr_weights" \ lf.toString).toString().toDouble)
      }
      catch {
        case e1: NumberFormatException => mlr_weights = None // Some(Double.MaxValue)
        // case e2: ArrayIndexOutOfBoundsException => println(lf)
      } // try {

      result = None
      // if (mlr_score.getOrElse(None)==None) || (mlr_weights.getOrElse(None) == None)
      if ((mlr_score.isEmpty) || (mlr_weights.isEmpty))
        result = None
      else
        result = Some(mlr_score.get.toString.toDouble * mlr_weights.get.toString.toDouble)

      listFeatureReturn = listFeatureReturn ::: List(new MySignal((lf.toString), mlr_score, mlr_weights, result))
    } // listFeatureS.foreach { lf =>

    listFeatureReturn // return
  } // def parseStreamSecond(json: JsValue): List[MySignal] = {

}

// class MyScoringComparator {