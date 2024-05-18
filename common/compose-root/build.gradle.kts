plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                implementation(Dependencies.Other.Navigation.core)
                implementation(project(":common:compose-utils"))
                implementation(project(":common:pokemon:compose"))
            }
        }

        androidMain{
            dependencies{

            }
        }

    }

}

android{
    namespace = "com.larkes.pokedexapp.compose.root"
}