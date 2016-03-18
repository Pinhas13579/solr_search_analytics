package demo

/**
  * Created by PPPP on 3/17/2016.
  */
// class MySignal(key2:String, score2: String, weight2: String, result2: String, precentage2: String) {
class MySignal(key2:String, score2: Double, weight2: Double) {
  var key: String = key2
  var score: Double = score2 //Option[Number]=None
  var weight: Double = weight2 //Option[Number] = None
  // var result: String = result2 //Option[Number] = None
  // var precentage: String = precentage2 //Option[Number] = None

  def getKey(): String = key
  def getScore(): Double = score
  def getWeight(): Double = weight
  // def getResult(): String = result
  // def getPrecentage(): String = precentage
}