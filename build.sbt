import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

val sttpVersion = "1.5.11"
val logbackVersion = "1.2.3"

lazy val root = (project in file("."))
  .settings(
    name := "graal-http",
  )

libraryDependencies ++=
  Seq(
    scalaTest % Test,
    "org.apache.httpcomponents" % "httpclient" % "4.5.7",
    "ch.qos.logback" % "logback-classic" % logbackVersion,
    "org.apache.logging.log4j" % "log4j-api" % "2.9.1"
  )


triggeredMessage := Watched.clearWhenTriggered

assemblyJarName in assembly := "graal-http.jar"
cancelable in Global := true


