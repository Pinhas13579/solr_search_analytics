package demo

/**
  * Created by PPPP on 3/8/2016.
  */
object MyScoringComparator {

  def main(args: Array[String]): Unit = {

    //
    val listFeatureForSearch: List[String] = List("attval.pcs_brand", "attval.pcs_actual_color", "ce.ce_v4",
      "attval.pcs_finish", "attval.pcs_category", "attval.pcs_condition", "attval.pcs_material",
      "attval.static_color", "dp.dp_v2", "cb.cb", "solr.score", "attval.pcs_wmt_category",
      "attval.raw_brand", "ce.qsrs_v1", "attval.pcs_color", "di.di")
    val listFeatureForAbcdef: List[String] = List("attval_dot_pcs_brand", "attval_dot_pcs_actual_color", "ce_dot_ce_v4",
      "attval_dot_pcs_finish", "attval_dot_pcs_category", "attval_dot_pcs_condition", "attval_dot_pcs_material",
      "attval_dot_static_color", "dp_dot_dp_v2", "cb_dot_cb", "solr_dot_score", "attval_dot_pcs_wmt_category",
      "attval_dot_raw_brand", "ce_dot_qsrs_v1", "attval_dot_pcs_color", "di_dot_di")


    // 1
    // val url = "http://api.geonames.org/postalCodeLookupJSON?postalcode=6600&country=AT&username=demo"
    // myJSON.setMyJsonUrl(url)
    // search.json
    val file1: String = "data/search.json"
    val myJSON_search: MyJSON = new MyJSON {}
    myJSON_search.setMyJson(file1, "file")

    // abcdef.json
    val file2: String = "data/abcdef.json"
    val myJSON_abcdef_previousItem: MyJSON = new MyJSON {}
    myJSON_abcdef_previousItem.setMyJson(file2, "file")
    // val myJSON_abcdef_latestItem: MyJSON = myJSON_abcdef_previousItem
    val myJSON_abcdef_latestItem: MyJSON = new MyJSON {}
    myJSON_abcdef_latestItem.setMyJson(file2, "file")



    // 2
    /*
    val json_search: JsValue = myJSON_search.getMyJson()
    val json_abcdef: JsValue = myJSON_abcdef.getMyJson()
    */


    // 3
    // search.json
    println("search.json")
    val searchItemArr = myJSON_search.parseStream(listFeatureForSearch)

    // println
    myJSON_search.toMyString(searchItemArr, listFeatureForSearch, "  |  ")



    // 4
    // abcdef.json
    println("abcdef.json")
    val previousItemArr = myJSON_abcdef_previousItem.parseStream(listFeatureForAbcdef, "previousItem")
    // myJSON_abcdef_previousItem.foreach(previousItemArr)

    val latestItemArr = myJSON_abcdef_latestItem.parseStream(listFeatureForAbcdef, "latestItem")
    // myJSON_abcdef_latestItem.foreach(latestItemArr)

    // println
    myJSON_abcdef_previousItem.toMyString(previousItemArr, latestItemArr, listFeatureForAbcdef, "  |  ")

  }

}
