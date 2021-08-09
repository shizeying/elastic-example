

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"
val elastic4sVersion = "7.9.3"

lazy val `elastic-example` = (project in file("."))

lazy val root = Project("elastic-example", file("."))
libraryDependencies ++= Seq(
	// recommended client for beginners
	"com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % elastic4sVersion,
	"com.sksamuel.elastic4s" %% "elastic4s-core" % elastic4sVersion,
	// test kit
	"com.sksamuel.elastic4s" %% "elastic4s-testkit" % elastic4sVersion % "test"
)




