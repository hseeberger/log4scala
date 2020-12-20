// *****************************************************************************
// Projects
// *****************************************************************************

lazy val log4scala =
  project
    .in(file("."))
    .enablePlugins(AutomateHeaderPlugin)
    .settings(commonSettings)
    .settings(
      libraryDependencies ++= Seq(
        library.log4jApi,
        library.log4jCore       % Test,
        library.mockitoScala    % Test,
        library.munit           % Test,
        library.munitScalaCheck % Test,
      ),
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val log4j   = "2.14.0"
      val mockito = "3.6.28"
      val munit   = "0.7.20"
    }
    val log4jApi        = "org.apache.logging.log4j" %  "log4j-api"        % Version.log4j
    val log4jCore       = "org.apache.logging.log4j" %  "log4j-core"       % Version.log4j
    val mockitoScala    = "org.mockito"              %  "mockito-core"     % Version.mockito
    val munit           = "org.scalameta"            %% "munit"            % Version.munit
    val munitScalaCheck = "org.scalameta"            %% "munit-scalacheck" % Version.munit
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val commonSettings =
  Seq(
    scalaVersion := "3.0.0-M3",
    organization := "rocks.heikoseeberger",
    organizationName := "Heiko Seeberger",
    startYear := Some(2020),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= Seq(
      "-encoding", "UTF-8",
    ),
    testFrameworks += new TestFramework("munit.Framework"),
    // TODO Enable once scalafmt supports Scala 3!
    // scalafmtOnCompile := true,
)
