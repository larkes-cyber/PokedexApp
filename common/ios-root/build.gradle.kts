plugins{
    id("multiplatform")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin{

    cocoapods{
        summary = "pokedex sdk"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            baseName = "SharedSDK"
            isStatic = true
            export(project(":common:core"))
            export(project(":common:pokemon:presentation"))
            export(project(":common:core-root"))
            export(Dependencies.Other.ViewModel.flow)
            export(Dependencies.Other.ViewModel.core)
        }

        sourceSets{
            commonMain{
                dependencies{
                    implementation(project(":common:core"))
                    implementation(project(":common:core-root"))
                    implementation(project(":common:pokemon:presentation"))
                    implementation(Dependencies.Other.ViewModel.flow)
                    implementation(Dependencies.Other.ViewModel.core)
                }
            }
            iosMain{
                dependencies{
                    api(project(":common:core"))
                    api(project(":common:core-root"))
                    api(project(":common:pokemon:presentation"))
                    api(Dependencies.Other.ViewModel.flow)
                    api(Dependencies.Other.ViewModel.core)
                }
            }

        }

    }

}

android{
    namespace = "com.larkes.pokedex.common.ios.root"
}