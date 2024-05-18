plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{

            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:pokemon:data"))
            }

        }

    }

}

android{
    namespace = "com.larkes.pokedex.core.root"
}