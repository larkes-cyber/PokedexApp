plugins{
    id("multiplatform")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin{

    cocoapods{
        summary = "Pokedex sdk"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            baseName = "SharedSDK"
            export(project(":common:core"))
            export(project(":common:core-root"))
            export(project(":common:pokemon:presentation"))
            isStatic = true
        }

        sourceSets{

            commonMain{
                dependencies{
                    implementation(project(":common:core"))
                    implementation(project(":common:core-root"))
                    implementation(project(":common:pokemon:presentation"))
                }
            }

            iosMain{
                dependencies{
                    api(project(":common:core"))
                    api(project(":common:core-root"))
                    api(project(":common:pokemon:presentation"))
                }
            }

        }

    }

}

android{
    namespace = "com.larkes.pokedex.common.ios.root"
}


