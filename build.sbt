name := """katangapp-backend"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.jsoup" % "jsoup" % "1.8.3",
  "commons-io" % "commons-io" % "2.4" % Test
)