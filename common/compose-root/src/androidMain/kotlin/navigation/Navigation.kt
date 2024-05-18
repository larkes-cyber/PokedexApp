package navigation

import NavigationTree
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import list.PokemonListScreen

@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navHostController, startDestination = NavigationTree.Pokemon.List.name){
        composable(NavigationTree.Pokemon.List.name){
            PokemonListScreen(navHostController)
        }
        composable(NavigationTree.Pokemon.Detail.name){

        }
    }

}