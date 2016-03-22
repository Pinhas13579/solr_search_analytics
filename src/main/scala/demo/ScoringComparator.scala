package demo

import spray.json._
import DefaultJsonProtocol._ // if you don't supply your own Protocol (see below)

/**
  * Created by PPPP on 2/14/2016.
  */



/*
TASK:

1. need a function that accepts JSON (search.json) and retunrs back a list of item_nubmers with two traits -
        one representing the previousItem and another latestItem
2. need to accept a string (HTML for now - example is 1.html) and retunrs back a list of item_nubmers with two traits -
        one representing the previousItem and another latestItem
3. function that takes two params (one from first function and another from the second function from above) -
        for each item in first list find the item in second list, calculate EACH individual feature score in the
        following formula and return back the list of item_numbers with one trait that has all those features
        with it's percentage.
The calculations is such - (old score - new score / old score). Caveat that the new score might be zero!!!
 */

/**
  *
  * @param key - signal name, repreented in String value, like:  attval.pcs_seating_capacity
  * @param score - pre JSON calculated value, Number type
  * @param weight - multiplicator that used to calculate the result
  * @param result - score * weight is the result
  */
case class Signal(key:String,
                  score: Option[Number] = None,
                  weight:Option[Number] = None,
                  result:Option[Number] = None,
                  percentage:Option[Number] = None)

/**
  *
  * @param itemId - unique id of each item
  * @param rerankedFinalScore - not sure if we will use it, let's just bring it from JSON
  * @param signals - the list of Signal objects
  */
case class SignalPerItem(itemId:String,
                         rerankedFinalScore:Option[Number] = None,
                         signals:List[Signal])


class ScoringComparator {

  def parseStream1 (json:String):List[SignalPerItem] = {
    val signal1 = Signal(key="attval.pcs_seating_capacity", score=Some(0.1385290063642662), weight=Some(1))
    val signal2 = Signal(key="attval.pcs_brand", score=Some(0.03272701540731556), weight=Some(1))
    val signal3 = Signal(key="attval.pcs_actual_color", score=Some(0.020568379980465016), weight=Some(1))
    val signal4 = Signal(key="ce.ce_v4", score=Some(0.3474082741499633), weight=Some(2.5))
    val signal5 = Signal(key="attval.pcs_category", score=Some(x = 0.27972525488701244), weight=Some(1))
    val signal6 = Signal(key="attval.pcs_material", score=Some(0.021353194137823536), weight=Some(1))
    val signal7 = Signal(key="attval.static_color", score=Some(0.007132397733697478), weight=Some(1))
    val signal8 = Signal(key="dp.dp_v2", score=Some(0.9841559529304504), weight=Some(1))
    val signal9 = Signal(key="cb.cb", score=Some(0), weight=Some(1))
    val signal10 = Signal(key="attval.pcs_fabric_material", score=Some(0.019421910074108015), weight=Some(1))
    val signal11 = Signal(key="solr.score", score=Some(1.1210333), weight=Some(0.001))
    val signal12 = Signal(key="attval.pcs_wmt_category", score=Some(0.3), weight=Some(1))
    val signal13 = Signal(key="attval.raw_brand", score=Some(0.03272701540731556), weight=Some(1))
    val signal14 = Signal(key="att.pcs_seating_capacity", score=Some(0.0012669307218528617), weight=Some(1))
    val signal15 = Signal(key="ce.qsrs_v1", score=Some(0.46566732006468975), weight=Some(2.5))
    val signal16 = Signal(key="attval.pcs_color", score=Some(0.020176531281186894), weight=Some(1))
    val signal17 = Signal(key="di.di", score=Some(1), weight=Some(0.29692466339))
    val signal18 = Signal(key="attval.pcs_seating_capacity_raw_data", score=Some(0.07689908891136658), weight=Some(1))
    val signalPerItem1 = SignalPerItem(itemId="45497792", signals=List(signal1, signal2, signal3, signal4,
      signal5, signal6, signal7, signal8, signal9, signal10, signal11, signal12,
      signal13, signal14, signal15, signal16, signal17, signal18))
    List(signalPerItem1)
  }
}