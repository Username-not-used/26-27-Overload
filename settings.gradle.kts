pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

/*@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pedropathing.com/")
        maven(url = "https://maven.rowanmcalpin.com/")
        maven(url = "https://maven.pedropathing.com/") // Remove if you don't intend to use PedroPathing
        maven(url = "https://maven.brott.dev/") // Remove if you don't intend to use the FTC Dashboard (required if using PedroPathing)
    }
}*/

rootProject.name = "Pedro Pathing"
include(":core")
include(":ftc")

