plugins{
    id("multiplatform")
    id ("org.jetbrains.kotlin.plugin.serialization")
}

kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:pokemon:api"))
                implementation(Dependencies.Ktor.serialization)

            }
        }
        androidUnitTest{
            dependencies{
                implementation(libs.kotlin.test)
                implementation(Dependencies.SqlDelight.testDriver)
                implementation(Dependencies.Ktor.test)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.cio)
            }
        }
    }
}

android{
    namespace = "com.larkes.pokedexapp.common.pokemon.data"
}