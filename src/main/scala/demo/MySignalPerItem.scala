package demo

import java.io.Serializable

/**
  * Created by PPPP on 3/17/2016.
  */
class MySignalPerItem(itemId2: String, rerankedFinalScore2: Option[String] = None, signals2: List[MySignal]) {

  private val itemId: String = itemId2
  private val rerankedFinalScore: Option[String] = rerankedFinalScore2
  private val signals: List[MySignal] = signals2

  def getItemId(): String = itemId

  def getRerankedFinalScore(): Serializable = rerankedFinalScore.getOrElse(None)

  def getSignals(): List[MySignal] = signals

} // class MySignalPerItem(itemId2: String, rerankedFinalScore2: Option[Number] = None, signals2: List[MySignal]) {
