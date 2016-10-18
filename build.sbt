name := "sbt-plantuml-plugin"

organization := "org.jug-montpellier"

version := "0.0.1"

sbtPlugin := true

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "8048"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"

publishMavenStyle := false

bintrayOrganization := Some("jug-montpellier")

bintrayRepository := "sbt-plugin-releases"

