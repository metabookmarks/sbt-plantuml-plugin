import sbtrelease.ReleaseStateTransformations._

name := "sbt-plantuml-plugin"

organization := "io.metabookmarks"

enablePlugins(SbtPlugin)

scalaVersion := "2.12.8"

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "1.2019.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.7" % Test

publishMavenStyle := false

bintrayOrganization := Some("metabookmarks")

bintrayRepository := "sbt-plugin-releases"

scalacOptions in console += "-Ywarn-unused-import"

crossSbtVersions := Vector("1.2.8", "0.13.17")

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
