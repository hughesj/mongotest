import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "mongo-app"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.mongodb" %% "casbah" % "2.6.2",
    "com.novus" %% "salat" % "1.9.2-SNAPSHOT",
    "org.scalatest" %% "scalatest" % "2.0.M5b" % "test")

  val main = play.Project(appName, appVersion, appDependencies).settings(
      // settings
      resolvers += Resolver.sonatypeRepo("snapshots")
  )

}
