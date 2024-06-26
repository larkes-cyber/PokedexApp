
plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        androidMain{
            dependencies{
                implementation(Dependencies.Other.ViewModel.compose)
                implementation(Dependencies.Other.Navigation.core)
                implementation(project(":common:compose-utils"))
                implementation(Dependencies.Android.Image.core)
            }
        }

        commonMain{
            dependencies{
                implementation(project(":common:pokemon:presentation"))


            }
        }

    }
}

android{
    namespace = "com.larkes.pokedexapp.common.pokemon.compose"
}