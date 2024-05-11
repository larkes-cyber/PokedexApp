plugins{
    id("multiplatform")
    id("app.cash.sqldelight")
}

sqldelight {
    databases {
        create("PokedexDatabase") {
            packageName.set("com.larkes.pokedexapp")
            generateAsync.set(true)
        }
    }
    linkSqlite = true
}

kotlin{
    sourceSets{

        androidMain{
            dependencies{
                implementation(Dependencies.Ktor.android_client)
                implementation(Dependencies.SqlDelight.androidDriver)
            }
        }

        commonMain{

            dependencies{
                implementation(Dependencies.Ktor.cio)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.serialization)
                api(Dependencies.Koin.core)
                api(Dependencies.Settings.settings)
            }

        }

        iosMain{
            dependencies{
                implementation(Dependencies.Ktor.ios_darwing)
                implementation(Dependencies.Ktor.ios_client)
                implementation(Dependencies.SqlDelight.iosDriver)
            }
        }
    }
}

android{
    namespace = "com.larkes.pokedexapp.core"
}