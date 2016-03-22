name := "ScoringComparator"

version := "1.0"

scalaVersion := "2.11.8"
val playVersion = "2.4.0-M1"

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "2.33.0" % "test",
  "org.testng" % "testng" % "6.1.1" % "test",
  "org.scalatest" % "scalatest_2.11" % "3.0.0-M15" % "test",

  "com.typesafe.play" %% "play-json" % playVersion,
  "io.spray" %%  "spray-json" % "1.3.2"
)