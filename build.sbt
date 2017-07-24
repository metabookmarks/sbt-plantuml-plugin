name := "sbt-plantuml-plugin"

organization := "org.jug-montpellier"

sbtPlugin := true

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "8059"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.3" % Test

publishMavenStyle := false

bintrayOrganization := Some("jug-montpellier")

bintrayRepository := "sbt-plugin-releases"

crossSbtVersions := Vector("0.13.15", "1.0.0-RC2")

releaseCrossBuild := true
