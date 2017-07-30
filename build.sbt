import sbtrelease.ReleaseStateTransformations._

name := "sbt-plantuml-plugin"

organization := "io.metabookmarks"

sbtPlugin := true

libraryDependencies += "net.sourceforge.plantuml" % "plantuml" % "8059"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.3" % Test

publishMavenStyle := false

bintrayOrganization := Some("metabookmarks")

bintrayRepository := "sbt-plugin-releases"

crossSbtVersions := Vector("0.13.16", "1.0.0-RC3")

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
