package plantuml

import sbt._
import Keys._
import net.sourceforge.plantuml.SourceFileReader

import scala.collection.JavaConverters._

object PlantUMLPlugin extends AutoPlugin {

  override def requires: Plugins = plugins.JvmPlugin

  override lazy val projectSettings = Seq(
    resourceGenerators in Compile += Def.task[Seq[File]] {
      val inputs = IO.listFiles(baseDirectory.value / "src/main/resources/diagram").toList

      val output = (resourceManaged in Compile).value / "diagram"

      IO.createDirectory(output)

      inputs.flatMap {
        input =>
          val plant = new SourceFileReader(input, output)
          plant.getGeneratedImages.asScala
      }.map(_.getPngFile)
    }.taskValue)

}
