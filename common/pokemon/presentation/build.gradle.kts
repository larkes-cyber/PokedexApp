plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{
                implementation(Dependencies.Other.ViewModel.core)
                api(project(":common:pokemon:api"))
                implementation(project(":common:core"))
            }
        }

    }
}

android{
    namespace = "com.larkes.pokedexapp.common.pokemon.presentation"
}