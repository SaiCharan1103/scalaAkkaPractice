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
//akka-actor
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.18"
//akka-actor-typed
libraryDependencies +="com.typesafe.akka" %% "akka-actor-typed"%"2.6.18"
//mongo Driver
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.4.1"
//akka-http
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.7"
//akka-stream
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.18"
//akka-http-spray-json
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.7"
//akka-alpakka-mongodb
libraryDependencies += "com.lightbend.akka" %% "akka-stream-alpakka-mongodb" % "3.0.4"
//slf4j
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.6.18"
//mysql
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.25"
//alpakka-stream-Slick
libraryDependencies += "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "3.0.4"
//simple mongo
libraryDependencies += "com.sfxcode.nosql" %% "simple-mongo" % "2.2.7"
//akka-http-circe
libraryDependencies += "de.heikoseeberger" %% "akka-http-circe" % "1.39.2"