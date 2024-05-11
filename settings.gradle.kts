enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokedexApp"
include(":androidApp")
include(":common:core")
include(":common:pokemon")
include(":common:core-utils")
include(":common:compose-utils")
include(":common:compose-root")
include(":common:ios-root")