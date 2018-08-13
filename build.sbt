name := "swagger-play"
version := "2.0.0-SNAPSHOT"

checksums in update := Nil

scalaVersion := "2.12.6"

crossScalaVersions := Seq(scalaVersion.value, "2.11.12")

val PlayVersion = "2.6.17"
val SwaggerVersion = "1.5.21"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % PlayVersion,
  "io.swagger" % "swagger-core" % SwaggerVersion,
  "io.swagger" %% "swagger-scala-module" % "1.0.4",
  "com.fasterxml.jackson.module"  %% "jackson-module-scala" % "2.9.6",
  "org.slf4j" % "slf4j-api" % "1.7.21",
  "com.typesafe.play" %% "routes-compiler" % "2.6.17",
  "com.typesafe.play" %% "play-ebean" % "4.0.2" % "test",
  "org.specs2" %% "specs2-core" % "4.3.3" % "test",
  "org.specs2" %% "specs2-mock" % "4.3.3" % "test",
  "org.specs2" %% "specs2-junit" % "4.3.3" % "test",
  "org.mockito" % "mockito-core" % "2.21.0" % "test")

scalacOptions in Test ~= filterConsoleScalacOptions

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
publishArtifact in Test := false
publishMavenStyle := true
pomIncludeRepository := { x => false }
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
organization := "io.swagger"
resolvers += Resolver.sonatypeRepo("snapshots")

parallelExecution in Test := false // existing code uses global state which breaks tests

pomExtra := {
  <url>http://swagger.io</url>
  <licenses>
    <license>
      <name>Apache License 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:swagger-api/swagger-play.git</url>
    <connection>scm:git:git@github.com:swagger-api/swagger-play.git</connection>
  </scm>
  <developers>
    <developer>
      <id>fehguy</id>
      <name>Tony Tam</name>
      <email>fehguy@gmail.com</email>
    </developer>
    <developer>
      <id>ayush</id>
      <name>Ayush Gupta</name>
      <email>ayush@glugbot.com</email>
    </developer>
    <developer>
      <id>rayyildiz</id>
      <name>Ramazan AYYILDIZ</name>
      <email>rayyildiz@gmail.com</email>
    </developer>
    <developer>
      <id>benmccann</id>
      <name>Ben McCann</name>
      <url>http://www.benmccann.com/</url>
    </developer>
    <developer>
      <id>frantuma</id>
      <name>Francesco Tumanischvili</name>
      <url>http://www.ft-software.net/</url>
    </developer>
    <developer>
      <id>gmethvin</id>
      <name>Greg Methvin</name>
      <url>https://methvin.net/</url>
    </developer>
  </developers>
}
