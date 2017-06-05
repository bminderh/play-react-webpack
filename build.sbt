import play.sbt.PlayImport.PlayKeys.playRunHooks

name := """circle"""

version := "0.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(
  // Disable NPM node modules
  JsEngineKeys.npmNodeModules in Assets := Nil,
  JsEngineKeys.npmNodeModules in TestAssets := Nil
)

scalaVersion := "2.11.8"

playRunHooks += baseDirectory.map(Webpack.apply).value

routesGenerator := InjectedRoutesGenerator

excludeFilter in (Assets, JshintKeys.jshint) := "*.js"

watchSources ~= { (ws: Seq[File]) =>
  ws filterNot { path =>
    path.getName.endsWith(".js") || path.getName == ("build")
  }
}

pipelineStages := Seq(rjs, digest, gzip)

RjsKeys.mainModule := "main"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += "TypeSafe snapshots" at "http://repo.typesafe.com/typesafe/snapshots"
resolvers += "TypeSafe releases" at "http://repo.typesafe.com/typesafe/releases"

resolvers += Resolver.jcenterRepo

fork in run := true

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  filters,
  specs2 % Test,
  "com.codeborne" % "phantomjsdriver" % "1.2.1",
  "org.mongodb.scala" %% "mongo-scala-driver" % "1.2.1",
  "org.rogach" %% "scallop" % "2.0.5",
  "com.mohiva" %% "play-silhouette" % "4.0.0",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "4.0.0",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "4.0.0",
  "com.mohiva" %% "play-silhouette-persistence" % "4.0.0",
  "com.mohiva" %% "play-silhouette-testkit" % "4.0.0" % "test",
  "net.codingwell" %% "scala-guice" % "4.0.1",
  "com.iheart" %% "ficus" % "1.2.6",
  "com.typesafe.play" %% "play-mailer" % "5.0.0"
)