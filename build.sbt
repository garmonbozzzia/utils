import sbt.io.IO
import sbt.librarymanagement.CrossVersion

name := "utils"

scalaVersion := "2.12.4"

organization := "org.gbz"

libraryDependencies += "com.lihaoyi" % "ammonite" % "1.0.3" cross CrossVersion.full


sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  IO.write(file, """object amm extends App { ammonite.Main().run() }""")
  Seq(file)
}.taskValue


//libraryDependencies += "com.lihaoyi" %% "pprint" % "0.5.3"
//libraryDependencies += "com.lihaoyi" %% "fastparse" % "0.4.4"
libraryDependencies += "com.lihaoyi" %% "utest" % "0.6.0" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")