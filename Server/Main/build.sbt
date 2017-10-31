name := "NUI4.0_Server"

version := "1.0"
scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

libraryDependencies += guice
libraryDependencies += javaWs
libraryDependencies += "org.webjars" % "bootstrap" % "2.3.2"
libraryDependencies += "org.webjars" % "flot" % "0.8.3"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.0"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.0.pr4"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.0.pr4"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.0.pr4"
libraryDependencies += "com.h2database" % "h2" % "1.4.196"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.1"

  // Machine Learning Tools

        // Mallet
//libraryDependencies += "cc.mallet" % "mallet" % "2.0.8"
        // TensorFlow
//libraryDependencies += "org.tensorflow" % "tensorflow" % "1.3.0"
//libraryDependencies += "org.tensorflow" % "libtensorflow_jni" % "1.3.0"
//libraryDependencies += "org.tensorflow" % "libtensorflow" % "1.3.0"
//libraryDependencies += "org.tensorflow" % "proto" % "1.3.0"
//libraryDependencies += "org.tensorflow" % "parentpom" % "1.3.0" pomOnly()


libraryDependencies ++= Seq(
  filters,
  javaJdbc,
  javaWs,
  cache,
  evolutions,
  jdbc,

  // bootstrap
  "org.webjars" % "bootstrap" % "3.3.7-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "3.2.1",
  "com.adrianhurt" %% "play-bootstrap" % "1.2-P25-B3",
  "com.vmunier" %% "scalajs-scripts" % "1.0.0",
  "org.tensorflow" % "tensorflow" % "1.3.0",
  "org.bytedeco.javacpp-presets" % "tensorflow" % "0.9.0-1.2",
  "net.java.dev.jna" % "jna-platform" % "4.1.0",
  "org.tensorflow" % "libtensorflow_jni" % "1.3.0",
  "org.tensorflow" % "libtensorflow" % "1.3.0",
  "org.tensorflow" % "proto" % "1.3.0",
  //"com.github.fommil.netlib" % "all" % "1.1.2" pomOnly(),
  "net.sourceforge.jexcelapi" % "jxl" % "2.6.10",



  "mysql" % "mysql-connector-java" % "5.1.38",
// postgresql driver
"org.postgresql" % "postgresql" % "9.4-1206-jdbc42"

)



// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.4.1" % Test
libraryDependencies += "com.jayway.awaitility" % "awaitility" % "1.7.0" % Test

// In order to import tf_models...
libraryDependencies += "org.bytedeco.javacpp-presets" % "tensorflow" % "1.0.1-1.3"

val akkaVersion = "2.5.0"
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test
libraryDependencies += "org.java-websocket" % "Java-WebSocket" % "1.3.4"

// CSV Building and Writing
libraryDependencies += "com.opencsv" % "opencsv" % "4.0"
//libraryDependencies += "org.apache.poi" % "poi" % "3.16"
//libraryDependencies += "org.apache.poi" % "poi-ooxml" % "3.16"

LessKeys.compress := true




unmanagedResourceDirectories in Compile += baseDirectory.value / "lib_extra"

includeFilter in (Compile, unmanagedResourceDirectories):= ".dll,.so"
