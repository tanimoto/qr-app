name := "qr-app"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  // QR Code
  "net.glxn" % "qrgen" % "1.3",
  // WebJars
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.0.0",
  "org.webjars" % "font-awesome" % "3.2.1",
  "org.webjars" % "jquery" % "1.10.2",
  "org.webjars" % "lodash" % "1.3.1",
  "org.webjars" % "modernizr" % "2.6.2-1",
  "org.webjars" % "angularjs" % "1.1.5",
  "org.webjars" % "angular-ui-bootstrap" % "0.5.0"
)

play.Project.playScalaSettings
