package demo

import play.api.libs.json._
import scala.io.Source
import scala.util.control.Breaks._

/**
  * Created by PPPP on 3/6/2016.
  */
abstract class MyJSON {
  private var myJSONS: JsValue = _

  def setMyJson(str: String, typeJSON: String) {
    typeJSON match {
      case "file" => myJSONS = Json.parse(Source.fromFile(str).getLines.mkString)
      case "url" => myJSONS = Json.parse(Source.fromURL(str).mkString)
    }
  }

  def getMyJson(): JsValue = myJSONS

  def foreachMy(itemArr: Array[Array[Double]]): Unit = {
    itemArr.foreach {
      i => i.foreach {
        j => print(j + "  ")
      }
        println()
    }
  }

  // for search
  def parseStream(listFeature: List[String]): Array[Array[Double]] = {
    val jsonItemS_id = (getMyJson() \ "response" \ "items" \\ "id")
    // val tempItemArr = Array.ofDim[Double](str_json_abcdef_previousItem.length, listFeature.length)
    val tempItemArr = Array.ofDim[Double](jsonItemS_id.length, listFeature.length * 2)
    var tempDoubleArr = Array[Double](2)
    // var nn: Int = 2 // lenght
    var idStr: String = null
    // var myListFeatureArr = new Array[Array[String]](listFeature1.size)(nn)
    // val hashMap = new mutable.HashMap[String, String]()
    // loop - id
    var ii: Int = 0
    jsonItemS_id.foreach {
      ii = 0
      id => // println("id: " + idStr)
        for (jj <- 0 to listFeature.length - 1) {
          tempDoubleArr = findFeatureDouble((getMyJson() \ "debug" \ "engine" \ "explain" \ id.toString().substring(1, id.toString().length - 1)).toString(), listFeature(jj))
          tempItemArr(ii)(jj * 2) = tempDoubleArr(0)
          tempItemArr(ii)(jj * 2 + 1) = tempDoubleArr(1)
          // println(listFeature(jj) + " - " + "#1-" + tempItemArr(ii)(jj * 2) + " #2-" + tempItemArr(ii)(jj * 2 + 1))
        } // for (ii <- 0 to listFeature.length - 1) {
        ii += 1
    } // str_json_search_id.foreach {

    return tempItemArr
  }

  // for abcdef
  def parseStream(listFeature: List[String], itemStr: String): Array[Array[Double]] = {
    val jsonItemS = (getMyJson() \ "items" \\ itemStr)
    val tempItemArr = Array.ofDim[Double](jsonItemS.length, listFeature.length)
    var ii: Int = 0
    jsonItemS.foreach {
      ii = 0
      item => println(item)
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
    } // str_json_abcdef_previousItem.foreach {

    return tempItemArr
  }

  // for search
  def toStringMy(itemArr: Array[Array[Double]], listFeature: List[String], spl: String): Unit = {
    var strPrint: String = ""
    var leng = 5 // length "ii"
    var dd = 5.123456 // previousItemArr - latestItemArr / previousItemArr
    var dn1 = 2 // length "ii"
    var dn2 = 10 //length "ii"
    for (ii <- 0 to itemArr.length - 1) {
      strPrint = f"${ii + 1}%5d)" + spl
      for (jj <- 0 to itemArr(ii).length / 2 - 1) {
        // dd = ((previousItemArr(ii)(jj) - latestItemArr(ii)(jj)) / previousItemArr(ii)(jj))
        strPrint += f"${((itemArr(ii)(jj) - itemArr(ii)(jj * 2 + 1)) / itemArr(ii)(jj))}%10s" + spl
        //print(((previousItemArr(ii)(jj) - latestItemArr(ii)(jj)) / previousItemArr(ii)(jj)).toString + spl)
      }
      println(strPrint)
    }
  }

  // for abcdef
  def toStringMy(previousItemArr: Array[Array[Double]], latestItemArr: Array[Array[Double]], listFeature: List[String], spl: String): Unit = {
    var strPrint: String = ""
    var leng = 5 // length "ii"
    var dd = 5.123456 // previousItemArr - latestItemArr / previousItemArr
    var dn1 = 2 // length "ii"
    var dn2 = 10 //length "ii"
    for (ii <- 0 to previousItemArr.length - 1) {
      strPrint = f"${ii + 1}%5d)" + spl
      for (jj <- 0 to previousItemArr(ii).length - 1) {
        // dd = ((previousItemArr(ii)(jj) - latestItemArr(ii)(jj)) / previousItemArr(ii)(jj))
        strPrint += f"${((previousItemArr(ii)(jj) - latestItemArr(ii)(jj)) / previousItemArr(ii)(jj))}%10s" + spl
        //print(((previousItemArr(ii)(jj) - latestItemArr(ii)(jj)) / previousItemArr(ii)(jj)).toString + spl)
      }
      println(strPrint)
    }
  }

  def findFeatureDouble(str: String, s: String): Array[Double] = {

    val nn: Int = 2 // lenght
    val arr = new Array[Double](nn)
    arr(0) = Double.MaxValue
    arr(1) = Double.MaxValue

    if (str.indexOf(s) == -1) // if can't found - return arr
      return arr

    // 1 time
    var i = str.indexOf(s) + s.length - 1 // найденно совпадение
    var i_start = 0
    var i_end = 0
    breakable {
      for (ii <- i to str.length) {
        if ((str.charAt(ii) equals (':')) && (i_start == 0))
          i_start = ii + 1
        if (((str.charAt(ii) equals (',')) || (str.charAt(ii) equals ('}'))) && (i_start != 0))
          i_end = ii - 1
        if ((i_start != 0) && (i_end != 0))
          break // BREAK!!
      }
    }

    if ((i_start == 0) && (i_end == 0))
      return arr
    // arr(0) = str.substring(i_start, i_end + 1).toDouble
    arr(0) = str.substring(i_start, i_end + 1).toDouble

    // 2 time
    i = str.indexOf(s, i_end) + s.length - 1 // найденно совпадение
    i_start = 0
    i_end = 0
    breakable {
      for (ii <- i to str.length) {
        if ((str.charAt(ii) equals (':')) && (i_start == 0))
          i_start = ii + 1
        if (((str.charAt(ii) equals (',')) || (str.charAt(ii) equals ('}'))) && (i_start != 0))
          i_end = ii - 1
        if ((i_start != 0) && (i_end != 0))
          break // BREAK!!
      }
    }
    // если не нашел - возвращаем arr
    if ((i_start == 0) && (i_end == 0))
      return arr
    // если нашел - добавляем и возвращаем arr
    // arr(1) = str.substring(i_start, i_end + 1).toDouble
    arr(1) = str.substring(i_start, i_end + 1).toDouble

    return arr
  }

}
