name := "spark2demo"

version := "1.0"

scalaVersion := "2.11.12"

val sparkVersion = "2.2.0"
val breezeVersion = "0.11.2"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/",
  "oracle-jdbc" at "http://search.maven.org/",
  Classpaths.typesafeReleases,
  "Typesafe" at "http://repo.typesafe.com/typesafe/releases/",
  "releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.0"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.8.2.2"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.8.2.2"
libraryDependencies += "org.scalanlp" %% "breeze" % breezeVersion
libraryDependencies += "org.scalanlp" %% "breeze-viz" % breezeVersion
libraryDependencies += "org.scalanlp" %% "breeze-natives" % breezeVersion
