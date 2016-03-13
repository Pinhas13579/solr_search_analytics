package demo

import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by PPPP on 2/8/2016.
  */
class ScoringComparatorTest_OLD1 extends FunSuite with BeforeAndAfterEach {

  val scoringComparator = new ScoringComparator

  test("parse stream 1") {
    println("parse stream 1")
    println(scoringComparator.parseStream1("json"))
    println
    assert(true==true)
  }

  test("parse stream 2") {
    println("parse stream 2")
    // println(scoringComparator.parseStream2("json"))
    println
    assert(true==true)
  }
}
