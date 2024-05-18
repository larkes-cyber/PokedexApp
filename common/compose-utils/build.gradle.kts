plugins{
    id("multiplatform")
}

kotlin{
    sourceSets{

        commonMain{
            dependencies{

            }
        }

    }
}

android{
    namespace = "com.larkes.pokedexapp.compose.utils"
}