name := "Graph_Library"

version := "0.1"

scalaVersion := "2.13.6"

idePackagePrefix := Some("com.project.graph")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test

libraryDependencies +="com.typesafe.slick" %% "slick" % "3.3.3"

libraryDependencies +="com.typesafe.slick" %% "slick-hikaricp" % "3.3.3"

libraryDependencies += "org.xerial"  %  "sqlite-jdbc" % "3.7.2"

libraryDependencies +=  "org.slf4j" % "slf4j-nop"  % "1.7.30"
