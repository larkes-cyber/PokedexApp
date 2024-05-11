object Dependencies {

    object Kotlin{
        private const val version = "1.9.20"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }
    object Ktor{
        private const val version = "2.0.0"
        const val core = "io.ktor:ktor-client-core:$version"
        const val android_client = "io.ktor:ktor-client-okhttp:$version"
        const val ios_darwing = "io.ktor:ktor-client-darwin:$version"
        const val ios_client = "io.ktor:ktor-client-ios:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val cio = "io.ktor:ktor-client-cio:$version"
        const val test = "io.ktor:ktor-client-mock:$version"
    }

    object Resource{
        private const val version = "0.23.0"
        const val gradlePlugin = "dev.icerock.moko:resources-generator:$version"
        const val core = "dev.icerock.moko:resources:$version"
    }

    object Compose{
        private const val version = "1.5.10"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }


    object Android{
        const val gradlePlugin = "com.android.tools.build:gradle:8.1.2"
        const val composeActivity = "androidx.activity:activity-compose:1.8.1"
        object Compose{
            private const val version = "1.5.10"
            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val icons = "androidx.compose.material:material-icons-core:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
        }
    }


    object SqlDelight{
        private const val version = "2.0.0"
        const val androidDriver = "app.cash.sqldelight:android-driver:$version"
        const val iosDriver = "app.cash.sqldelight:native-driver:$version"
        const val testDriver = "app.cash.sqldelight:sqlite-driver:$version"
        const val gradlePlugin = "app.cash.sqldelight:gradle-plugin:$version"
    }

    object Koin{
        private const val version = "3.3.3"
        const val core = "io.insert-koin:koin-core:$version"
    }

    object Serialization{
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.9.20"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2"
    }

    object Coroutines{
        private const val version = "1.7.3"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }

    object Settings{
        private const val version = "1.1.0"
        const val settings = "com.russhwolf:multiplatform-settings-no-arg:$version"
    }



}