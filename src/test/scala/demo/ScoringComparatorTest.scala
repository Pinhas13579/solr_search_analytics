package demo

import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by PPPP on 2/8/2016.
  */
class ScoringComparatorTest extends FunSuite with BeforeAndAfterEach {

  val scoringComparator = new ScoringComparator

  test("parse stream 1") {
    println("parse stream 1")
    println(scoringComparator.parseStream1("json"))
    println
    assert(true)
  }
}
