lazy val root = (project in file(".")).
	settings(
		scalaVersion := "2.11.7",
		libraryDependencies += "joda-time" % "joda-time" % "2.9.4",
		libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
	)