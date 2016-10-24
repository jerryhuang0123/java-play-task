name := """java-play-task"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
EclipseKeys.preTasks := Seq(compile in Compile)
scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.twitter4j" % "twitter4j-core" % "4.0.4"
)


fork in run := false