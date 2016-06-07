lazy val root = (project in file(".")).
	settings(
		libraryDependencies += "joda-time" % "joda-time" % "2.0"
	)