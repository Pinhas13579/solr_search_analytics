package demo

import java.io.Serializable

/**
  * Created by PPPP on 3/17/2016.
  */
class MySignal(key2: String, score2: Option[Number] = None, weight2: Option[Number] = None, result2: Option[Number] = None, precentage2: Option[Number] = None) {

  private val key: String = key2
  private val score: Option[Number] = score2
  private val weight: Option[Number] = weight2
  private val result: Option[Number] = result2
  private val precentage: Option[Number] = precentage2

  def getKey(): String = key

  def getScore(): Serializable = score.getOrElse(None)

  def getWeight(): Serializable = weight.getOrElse(None)

  def getResult(): Serializable = result.getOrElse(None)

  def getPrecentage(): Serializable = precentage.getOrElse(None)

} // class MySignal(key2: String, score2: Option[Number] = None, weight2: Option[Number] = None, result2: Option[Number] = None, precentage2: Option[Number] = None) {