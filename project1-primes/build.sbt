lazy val root = (project in file(".")).
	settings(
		libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
	)