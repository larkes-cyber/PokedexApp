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
include(":common:core-utils")
include(":common:compose-utils")
include(":common:pokemon:api")
include(":common:pokemon:data")
include(":common:pokemon:compose")
include(":common:pokemon:presentation")
include(":common:compose-root")
include(":common:ios-root")
include(":common:core-root")