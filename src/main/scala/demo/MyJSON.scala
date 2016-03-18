package demo

/**
  * Created by PPPP on 3/17/2016.
  */
object MyJSON {
  def main(args: Array[String]): Unit = {

    // Values for abcdef.json
    val listFeatureFor_abcdef: List[String] = List("attval_dot_pcs_brand", "attval_dot_pcs_actual_color",
      "ce_dot_ce_v4", "attval_dot_pcs_finish", "attval_dot_pcs_category", "attval_dot_pcs_condition",
      "attval_dot_pcs_material", "attval_dot_static_color", "dp_dot_dp_v2", "cb_dot_cb", "solr_dot_score",
      "attval_dot_pcs_wmt_category", "attval_dot_raw_brand", "ce_dot_qsrs_v1",
      "attval_dot_pcs_color", "di_dot_di")


    // 1
    // URL
    // val str = "http://api.geonames.org/postalCodeLookupJSON?postalcode=6600&country=AT&username=demo"
    // val typeJSON: String = "url"
    // FILE - abcdef.json
    val str: String = "data/abcdef.json"
    val typeJSON: String = "file"
    val myScoringComparator: MyScoringComparator = new MyScoringComparator()

    // 2 - previousItem and latestItem
    println("previousItem")
    var itemStr: String = "previousItem"
    val myListPrevious: List[MySignalPerItem] = myScoringComparator.parseStreamFirst(str, typeJSON, itemStr, listFeatureFor_abcdef) // Result - previous!!!!!!!!!!!!!

    myListPrevious.foreach {
      lp =>
        println(lp.getItemId())
        println(lp.getRerankedFinalScore())
        lp.getSignals().foreach {
          ls =>
            println("              " + ls.getKey() + "              " + ls.getScore() + "              " + ls.getWeight())
        }
    }

    println("latestItem")
    itemStr = "latestItem"
    val myListLatest: List[MySignalPerItem] = myScoringComparator.parseStreamFirst(str, typeJSON, itemStr, listFeatureFor_abcdef) // Result - latest!!!!!!!!!!!!!

    myListLatest.foreach {
      lp =>
        println(lp.getItemId())
        println(lp.getRerankedFinalScore())
        lp.getSignals().foreach {
          ls =>
            println("              " + ls.getKey() + "              " + ls.getScore() + "              " + ls.getWeight())
        }
    }


    // 3 - toString

  }
}
