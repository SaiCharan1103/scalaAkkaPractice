ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.4"

lazy val root = (project in file("."))
  .settings(
    name := "scalaPractice"
  )
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"
libraryDependencies += "com.fasterxml.jackson.module"  % "jackson-module-scala_2.12"  % "2.13.1"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.1"
//libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.6"
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.8"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.18"
//mongo Driver
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.4.1"