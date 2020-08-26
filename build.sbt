//Customized release
import sbtrelease.ReleaseStateTransformations._

name := "sbt-plantuml-plugin"

organization := "io.metabookmarks"

enablePlugins(SbtPlugin)

scalaVersion := "2.12.10"

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "1.2020.16"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test

scalafmtOnCompile := true

publishMavenStyle := false

bintrayOrganization := Some("metabookmarks")

bintrayRepository := "sbt-plugin-releases"

scalacOptions in console += "-Ywarn-unused-import"

crossSbtVersions := Vector("1.3.3", "0.13.18")

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
