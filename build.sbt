name := "sbt-plantuml-plugin"

organization := "org.jug-montpellier"

sbtPlugin := true

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "8057"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"

publishMavenStyle := false

bintrayOrganization := Some("jug-montpellier")

bintrayRepository := "sbt-plugin-releases"

