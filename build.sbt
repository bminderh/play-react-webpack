import play.sbt.PlayImport.PlayKeys.playRunHooks

name := """circle"""

version := "0.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(
  // Disable NPM node modules
  JsEngineKeys.npmNodeModules in Assets := Nil,
  JsEngineKeys.npmNodeModules in TestAssets := Nil
)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "com.codeborne" % "phantomjsdriver" % "1.2.1",
  "org.mongodb.scala" %% "mongo-scala-driver" % "1.2.1",
  "org.rogach" %% "scallop" % "2.0.5"
)

playRunHooks += baseDirectory.map(Webpack.apply).value

routesGenerator := InjectedRoutesGenerator

excludeFilter in (Assets, JshintKeys.jshint) := "*.js"

watchSources ~= { (ws: Seq[File]) =>
  ws filterNot { path =>
    path.getName.endsWith(".js") || path.getName == ("build")
  }
}

pipelineStages := Seq(digest, gzip)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += "TypeSafe snapshots" at "http://repo.typesafe.com/typesafe/snapshots"
resolvers += "TypeSafe releases" at "http://repo.typesafe.com/typesafe/releases"

fork in run := true