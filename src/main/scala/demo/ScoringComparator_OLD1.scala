package demo

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

case class Item1(item:Integer, previousFeatures:Features, lastFeatures:Features)
case class Item2(item:Integer, features:Features)

case class Features(attval_dot_pcs_brand:Integer,
        attval_dot_pcs_actual_color:Integer,
        ce_dot_ce_v4:Integer,
        attval_dot_pcs_finish:Integer,
        attval_dot_pcs_category:Integer,
        attval_dot_pcs_condition:Integer,
        attval_dot_pcs_material:Integer,
        attval_dot_static_color:Integer,
        dp_dot_dp_v2:Integer,
        cb_dot_cb:Integer,
        solr_dot_score:Integer,
        attval_dot_pcs_wmt_category:Integer,
        attval_dot_raw_brand:Integer,
        ce_dot_qsrs_v1:Integer,
        attval_dot_pcs_color:Integer,
        di_dot_d:Integer)

class ScoringComparator_OLD1 {

  def parseStream1 (json:String):List[Item1] = {
    //todo: implement this
    val previousFeatures = Features(attval_dot_pcs_brand = 1,
      attval_dot_pcs_actual_color = 2,
      ce_dot_ce_v4 = 3,
      attval_dot_pcs_finish = 4,
      attval_dot_pcs_category = 5,
      attval_dot_pcs_condition = 6,
      attval_dot_pcs_material = 7,
      attval_dot_static_color = 8,
      dp_dot_dp_v2 = 9,
      cb_dot_cb = 10,
      solr_dot_score = 11,
      attval_dot_pcs_wmt_category = 12,
      attval_dot_raw_brand = 13,
      ce_dot_qsrs_v1 = 14,
      attval_dot_pcs_color = 15,
      di_dot_d = 16)

    val lastFeatures = Features(attval_dot_pcs_brand = 1,
      attval_dot_pcs_actual_color = 2,
      ce_dot_ce_v4 = 3,
      attval_dot_pcs_finish = 4,
      attval_dot_pcs_category = 5,
      attval_dot_pcs_condition = 6,
      attval_dot_pcs_material = 7,
      attval_dot_static_color = 8,
      dp_dot_dp_v2 = 9,
      cb_dot_cb = 10,
      solr_dot_score = 11,
      attval_dot_pcs_wmt_category = 12,
      attval_dot_raw_brand = 13,
      ce_dot_qsrs_v1 = 14,
      attval_dot_pcs_color = 15,
      di_dot_d = 16)
    val item1 = Item1(item=123456, previousFeatures = previousFeatures, lastFeatures = lastFeatures)
    List(item1)
  }

  def parseStream2(json:String):List[Item2] = {
    val previousFeatures = Features(attval_dot_pcs_brand = 1,
      attval_dot_pcs_actual_color = 2,
      ce_dot_ce_v4 = 3,
      attval_dot_pcs_finish = 4,
      attval_dot_pcs_category = 5,
      attval_dot_pcs_condition = 6,
      attval_dot_pcs_material = 7,
      attval_dot_static_color = 8,
      dp_dot_dp_v2 = 9,
      cb_dot_cb = 10,
      solr_dot_score = 11,
      attval_dot_pcs_wmt_category = 12,
      attval_dot_raw_brand = 13,
      ce_dot_qsrs_v1 = 14,
      attval_dot_pcs_color = 15,
      di_dot_d = 16)

    val item2 = Item2(item=123456, features = previousFeatures)
    List(item2)
  }
}
