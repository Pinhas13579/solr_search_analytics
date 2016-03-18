package demo

/**
  * Created by PPPP on 3/17/2016.
  */
class MySignalPerItem(itemId2: String, rerankedFinalScore2: String, signals2: List[MySignal]) {
  var itemId: String = itemId2
  // var latestItem: Boolean=false
  var rerankedFinalScore: String = rerankedFinalScore2 // Option[Number] = None
  var signals: List[MySignal] = signals2

  def getItemId(): String = itemId

  def getRerankedFinalScore(): String = rerankedFinalScore

  def getSignals(): List[MySignal] = signals

} // class MySignalPerItem(itemId2: String, rerankedFinalScore2: String, signals2: List[MySignal]) {
