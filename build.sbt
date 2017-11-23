import sbtrelease.ReleaseStateTransformations._

scalafixSemanticdbVersion := "2.1.2"

name := "sbt-plantuml-plugin"

organization := "io.metabookmarks"

sbtPlugin := true

scalaVersion := "2.12.4"

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "1.2017.19"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test

publishMavenStyle := false

bintrayOrganization := Some("metabookmarks")

bintrayRepository := "sbt-plugin-releases"

scalacOptions in console += "-Ywarn-unused-import"

crossSbtVersions := Vector("0.13.16", "1.0.3")

releaseCrossBuild := true

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  releaseStepCommandAndRemaining("^ test"),
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("^ publish"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
