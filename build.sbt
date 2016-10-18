name := "sbt-plantuml-plugin"

organization := "org.montpellier-jug"

version := "1.0.0"

sbtPlugin := true

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "8048"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"

resolvers += Resolver.defaultLocal