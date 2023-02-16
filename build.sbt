name := """product-PlayJava"""
organization := "tarento"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.10"

libraryDependencies += guice

libraryDependencies += "com.typesafe.play" %% "play-java" % "2.8.2"
libraryDependencies += "org.elasticsearch" % "elasticsearch" % "7.10.0"
libraryDependencies += "org.elasticsearch.client" % "elasticsearch-rest-high-level-client" % "7.10.0"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.32"


