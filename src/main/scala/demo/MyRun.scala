package demo

import java.io.Serializable

/**
  * Created by PPPP on 3/17/2016.
  */
object MyRun {
  def main(args: Array[String]): Unit = {

    // 0 - Values for abcdef.json
    /*
    val listFeatureFor_abcdef: List[String] = List("attval_dot_pcs_brand", "attval_dot_pcs_actual_color",
      "ce_dot_ce_v4", "attval_dot_pcs_finish", "attval_dot_pcs_category", "attval_dot_pcs_condition",
      "attval_dot_pcs_material", "attval_dot_static_color", "dp_dot_dp_v2", "cb_dot_cb", "solr_dot_score",
      "attval_dot_pcs_wmt_category", "attval_dot_raw_brand", "ce_dot_qsrs_v1",
      "attval_dot_pcs_color", "di_dot_di")
      */
    val listFeatureS: List[String] = List(
      "attval_dot_pcs_seating_capacity",
      "attval_dot_pcs_brand",
      "attval_dot_pcs_actual_color",
      "ce_dot_ce_v4",
      "attval_dot_pcs_category",
      "attval_dot_pcs_material",
      "attval_dot_static_color",
      "dp_dot_dp_v2",
      "cb_dot_cb",
      "attval_dot_pcs_fabric_material",
      "solr_dot_score",
      "attval_dot_pcs_wmt_category",
      "attval_dot_raw_brand",
      "att_dot_pcs_seating_capacity",
      "ce_dot_qsrs_v1",
      "attval_dot_pcs_color",
      "di_dot_di",
      "attval_dot_pcs_seating_capacity_raw_data"
    )


    // 1
    // URL
    // val str = "http://api.geonames.org/postalCodeLookupJSON?postalcode=6600&country=AT&username=demo"
    // val typeJSON: String = "url"
    // FILE - abcdef.json
    val file: String = "data/abcdef.json"
    val typeJSON: String = "file"


    // 2-1 - previousItem
    // println("previousItem")
    val myScoringComparatorListPrevious: MyScoringComparator = new MyScoringComparator(file, typeJSON, "previousItem", listFeatureS)
    val myListPrevious: List[MySignalPerItem] = myScoringComparatorListPrevious.getMyList() // Result - previous!!!!!!!!!!!!!

    /*
    myListPrevious.foreach { lp =>
        println(lp.getItemId())
        println(lp.getRerankedFinalScore())
        lp.getSignals().foreach {
          ls =>
            println("              " + ls.getKey() + "              " + ls.getScore() + "              " + ls.getWeight() + "              " + ls.getResult())
        }
    }
    */

    // 2-2 - latestItem
    // println("latestItem")
    val myScoringComparatorListLatest: MyScoringComparator = new MyScoringComparator(file, typeJSON, "latestItem", listFeatureS)
    val myListLatest: List[MySignalPerItem] = myScoringComparatorListLatest.getMyList() // Result - latest!!!!!!!!!!!!!

    /*
    myListLatest.foreach { lp =>
        println(lp.getItemId())
        println(lp.getRerankedFinalScore())
        lp.getSignals().foreach {
          ls =>
            println("              " + ls.getKey() + "              " + ls.getScore() + "              " + ls.getWeight() + "              " + ls.getResult())
        }
    }
    */


    // 3 - precentage = (last - pr) / last
    println("precentage = (last - pr) / last")
    val myListPrecentage: List[MySignalPerItem] = myScoringComparatorListPrevious.myCalcPrecentage(myScoringComparatorListLatest.getMyList())

    //*
    myListPrecentage.foreach { lp =>
        println("ItemId - " + lp.getItemId())
        println("RerankedFinalScore(previousItem-latestItem) - " + lp.getRerankedFinalScore())
        lp.getSignals().foreach {
          ls =>
            println("              " + ls.getKey() + "              " + ls.getScore() + "              " + ls.getWeight() + "              " + ls.getResult() + "              " + ls.getPrecentage())
        }
      println()
    }
    //*/

    // 4-1 - filter = 23146535
    println("Filter - 23146535")
    // var result1: Serializable = None
    // result1 = signals1.filter(_.getKey() == lf).head.getResult()
    var myFilter = myListPrecentage.filter(_.getItemId() == "23146535")
    println(myFilter.length)
    myFilter.foreach{ mf =>
      println("ItemId - " + mf.getItemId())
      println("RerankedFinalScore(previousItem-latestItem) - " + mf.getRerankedFinalScore())
      mf.getSignals().foreach {
        ls =>
          println("              " + ls.getKey() + "              " + ls.getScore() + "              " + ls.getWeight() + "              " + ls.getResult() + "              " + ls.getPrecentage())
      }
      println()
    }

    // 4-2 - filter = 46716836
    println("Filter - 46716836")
    myFilter = myListPrecentage.filter(_.getItemId() == 46716836.toString)
    println(myFilter.length)
    myFilter.foreach{ mf =>
      println("ItemId - " + mf.getItemId())
      println("RerankedFinalScore(previousItem-latestItem) - " + mf.getRerankedFinalScore())
      mf.getSignals().foreach {
        ls =>
          println("              " + ls.getKey() + "              " + ls.getScore() + "              " + ls.getWeight() + "              " + ls.getResult() + "              " + ls.getPrecentage())
      }
      println()
    }
  }
}
