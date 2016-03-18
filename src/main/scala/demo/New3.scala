package demo

import scala.util.control.Breaks._

/**
  * Created by PPPP on 3/7/2016.
  */
object New3 extends App {

  var as: List[String] = List()
  as = as ::: List("1")
  as = as ::: List("2")
  as = as ::: List("4")
  as = as ::: List("3")

  as.foreach{
    q => println(q)
  }

  val a = Array.ofDim[String](2, 2)
  a(0)(0) = "1"
  a(0)(1) = "2"
  a(1)(0) = "3"
  a(1)(1) = "e3"

  var a2: Int = 0

  a.foreach {
    arr1 =>
      arr1.foreach {
        arr2 => // println(arr2)
          try {
            a2 = arr2.toInt
          }
          catch {
            case e: NumberFormatException => a2 = 5555
          } // try {

          println(a2)
      }
  }


  /*

  val pattern = "qsrs_v1"
  val str = "\\n0.8140662 = (MATCH) pc(boost(+(title_kstem:\\\"analog atomic wall clock\\\"~4^0.9 | secondary_shelves:\\\"analog atomic wall clock\\\"~4^0.1 | department_kstem:\\\"analog atomic wall clock\\\"~4^0.1 | zero_polaris_cat:\\\"analog atomic wall clock\\\"~4^0.05 | all_description_raw:\\\"analog atomic wall clock\\\"~4^0.001 | all_description_kstem:\\\"analog atomic wall clock\\\"~4^0.01 | curated_srch_desc_kstem:\\\"analog atomic wall clock\\\"~4^0.9 | partial_polaris_cat:\\\"analog atomic wall clock\\\"~4^0.1 | multi_attributes_raw:\\\"analog atomic wall clock\\\"~4^0.2 | standardized_upc:\\\"analog atomic +wall +clock\\\"~4^0.001 | curated_srch_desc_string:analog atomic +wall +clock | title_raw:\\\"analog atomic wall clock\\\"~4 | console_str:analog atomic +wall +clock^1.5 | primary_category_path_ids:\\\"analog atomic wall clock\\\"~4 | exact_polaris_cat:\\\"analog atomic wall clock\\\"~4^0.1 | shelf_kstem:\\\"analog atomic wall clock\\\"~4^0.1 | misc_attributes_raw:\\\"analog atomic wall clock\\\"~4^0.2 | single_attributes_raw:\\\"analog atomic wall clock\\\"~4^0.2 | hubble_queries_high_precision_kstem:\\\"analog atomic wall clock\\\"~4^0.9)~0.1 (((primary_category_id_path_constidf:4044/133012/642059 | ￼￼￼:dummy)~0.1 (primary_category_id_path_constidf:4044133012642059 | ￼￼￼:dummy)~0.1)^1.48) (float(precomputed_popularity_bf))^1.5,product(float(precomputed_newness_price_boost),if(exists(float(merchant_boost)),float(merchant_boost),const(1.0))))), product of:\\n  0.8140662 = (MATCH) boost(+(title_kstem:\\\"analog atomic wall clock\\\"~4^0.9 | secondary_shelves:\\\"analog atomic wall clock\\\"~4^0.1 | department_kstem:\\\"analog atomic wall clock\\\"~4^0.1 | zero_polaris_cat:\\\"analog atomic wall clock\\\"~4^0.05 | all_description_raw:\\\"analog atomic wall clock\\\"~4^0.001 | all_description_kstem:\\\"analog atomic wall clock\\\"~4^0.01 | curated_srch_desc_kstem:\\\"analog atomic wall clock\\\"~4^0.9 | partial_polaris_cat:\\\"analog atomic wall clock\\\"~4^0.1 | multi_attributes_raw:\\\"analog atomic wall clock\\\"~4^0.2 | standardized_upc:\\\"analog atomic +wall +clock\\\"~4^0.001 | curated_srch_desc_string:analog atomic +wall +clock | title_raw:\\\"analog atomic wall clock\\\"~4 | console_str:analog atomic +wall +clock^1.5 | primary_category_path_ids:\\\"analog atomic wall clock\\\"~4 | exact_polaris_cat:\\\"analog atomic wall clock\\\"~4^0.1 | shelf_kstem:\\\"analog atomic wall clock\\\"~4^0.1 | misc_attributes_raw:\\\"analog atomic wall clock\\\"~4^0.2 | single_attributes_raw:\\\"analog atomic wall clock\\\"~4^0.2 | hubble_queries_high_precision_kstem:\\\"analog atomic wall clock\\\"~4^0.9)~0.1 (((primary_category_id_path_constidf:4044/133012/642059 | ￼￼￼:dummy)~0.1 (primary_category_id_path_constidf:4044133012642059 | ￼￼￼:dummy)~0.1)^1.48) (float(precomputed_popularity_bf))^1.5,product(float(precomputed_newness_price_boost),if(exists(float(merchant_boost)),float(merchant_boost),const(1.0)))), product of:\\n    0.74006015 = (MATCH) sum of:\\n      0.50662047 = (MATCH) BM25F score combination, product of:\\n        21.135794 =  idf (docFreq:analog=5254,atomic=1139,clock=9540,wall=244814,numDocs:2143892)\\n        0.055327438 = queryNorm\\n        0.43323508 = K1: 1.911/(1.911 + 2.5)\\n          0.9 = (title_kstem:analog atomic clock wall ) B:0.4, Length:1.0, AvgLength:1.0, LengthRatio: 1.0, Freq:1.0, Boost:0.9\\n            0.9 = freq*boost\\n            1.0 = 1 - b + b * L/avgL\\n          0.001 = (all_description_raw:analog atomic clock wall ) B:0.2, Length:1.0, AvgLength:1.0, LengthRatio: 1.0, Freq:1.0, Boost:0.001\\n            0.001 = freq*boost\\n            1.0 = 1 - b + b * L/avgL\\n          0.01 = (all_description_kstem:analog atomic clock wall ) B:0.2, Length:1.0, AvgLength:1.0, LengthRatio: 1.0, Freq:1.0, Boost:0.01\\n            0.01 = freq*boost\\n            1.0 = 1 - b + b * L/avgL\\n          1.0 = (title_raw:analog atomic clock wall ) B:0.4, Length:1.0, AvgLength:1.0, LengthRatio: 1.0, Freq:1.0, Boost:1.0\\n            1.0 = freq*boost\\n            1.0 = 1 - b + b * L/avgL\\n      0.21056044 = (MATCH) sum of:\\n        0.10528022 = (MATCH) BM25F score combination, product of:\\n          4.5 =  idf \\n          0.08188461 = queryNorm\\n          0.2857143 = K1: 1.0/(1.0 + 2.5)\\n            1.0 = (primary_category_id_path_constidf:) B:0.75, Length:1.0, AvgLength:1.0, LengthRatio: 1.0, Freq:1.0, Boost:1.0\\n              1.0 = freq*boost\\n              1.0 = 1 - b + b * L/avgL\\n        0.10528022 = (MATCH) BM25F score combination, product of:\\n          4.5 =  idf \\n          0.08188461 = queryNorm\\n          0.2857143 = K1: 1.0/(1.0 + 2.5)\\n            1.0 = (primary_category_id_path_constidf:) B:0.75, Length:1.0, AvgLength:1.0, LengthRatio: 1.0, Freq:1.0, Boost:1.0\\n              1.0 = freq*boost\\n              1.0 = 1 - b + b * L/avgL\\n      0.022879254 = (MATCH) FunctionQuery(float(precomputed_popularity_bf)), product of:\\n        0.27568305 = float(precomputed_popularity_bf)=0.27568305\\n        1.5 = boost\\n        0.055327438 = queryNorm\\n    1.1 = product(float(precomputed_newness_price_boost)=1.1,if(exists(float(merchant_boost)=0.0),float(merchant_boost)=0.0,const(1.0)))\\n\\nRerank.Debug.Info = {\\\"mlr_framework_model_name\\\":\\\"[letor_rf_v1]\\\",\\\"mlr_framework_model_score\\\":\\\"[0.9934643280629097]\\\",\\\"mlr_framework_model_type\\\":\\\"[com.walmart.labs.solr.handler.component.mlrerank.model.LinearModel]\\\",\\\"mlr_framework_weights\\\":\\\"[{\\\\\\\"attval.pcs_category\\\\\\\":1.0,\\\\\\\"solr.score\\\\\\\":0.001,\\\\\\\"attval.pcs_condition\\\\\\\":1.0,\\\\\\\"attval.pcs_wmt_category\\\\\\\":1.0,\\\\\\\"attval.pcs_material\\\\\\\":1.0,\\\\\\\"attval.is_media\\\\\\\":1.0,\\\\\\\"ce.qsrs_v1\\\\\\\":2.5,\\\\\\\"dp.dp_v2\\\\\\\":1.0,\\\\\\\"cb.cb\\\\\\\":1.0,\\\\\\\"di.di\\\\\\\":0.29692466339,\\\\\\\"attval.pcs_lifestage\\\\\\\":1.0}]\\\",\\\"mlr_framework_features\\\":\\\"[{\\\\\\\"attval.pcs_category\\\\\\\":0.3,\\\\\\\"solr.score\\\\\\\":0.8140662,\\\\\\\"attval.pcs_condition\\\\\\\":0.015959166703638353,\\\\\\\"attval.pcs_wmt_category\\\\\\\":0.26668942384692074,\\\\\\\"attval.pcs_material\\\\\\\":0.05988670755247495,\\\\\\\"attval.is_media\\\\\\\":0.0023351314687765135,\\\\\\\"ce.qsrs_v1\\\\\\\":0.0,\\\\\\\"dp.dp_v2\\\\\\\":0.0,\\\\\\\"cb.cb\\\\\\\":0.0,\\\\\\\"di.di\\\\\\\":1.0,\\\\\\\"attval.pcs_lifestage\\\\\\\":0.05085516890109923}]\\\"}"

  val i = str.indexOf(pattern) + pattern.length-1
  println(i)
  println((str.charAt(i)))


  var q = str.indexOf(pattern, i + pattern.length)
  println("q - " + q)
  println((str.charAt(q)))

  var i_start = 0
  var i_end = 0
  var i_str = ""

  breakable{
    for(ii <- i to str.length) {
      if ((str.charAt(ii) equals (':')) && (i_start == 0)) {
        i_start = ii + 1
        println("i_start - " + i_start + " - " + str.charAt(i_start))
      }
      if ((str.charAt(ii) equals (',')) && (i_start != 0)) {
        i_end = ii - 1
        println("i_end - " + i_end + " - " + str.charAt(i_end))
      }
      if ((i_start != 0) && (i_end != 0)){
        break // BREAK!!
      }
    }
  }
  i_str = str.substring(i_start, i_end+1)
  println(i_str)*/
}
