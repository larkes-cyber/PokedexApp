package navigation

import NavigationTree
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import detail.PokemonDetailScreen
import list.PokemonListScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ){
        NavHost(navHostController, startDestination = NavigationTree.Pokemon.List.name){
            composable(NavigationTree.Pokemon.List.name){
                PokemonListScreen(navHostController)
            }
            composable(
                route = NavigationTree.Pokemon.Detail.name + "/{id}",
                arguments = listOf(
                    navArgument("id"){
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ){
                val id  = it.arguments?.getString("id") ?: ""
                EnterAnimation {
                    PokemonDetailScreen(navController = navHostController, id = id)
                }
            }
        }
    }

}

@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visibleState = MutableTransitionState(
            initialState = false
        ).apply { targetState = true },
        modifier = Modifier,
        enter = slideInVertically() + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
    ) {
        content()
    }
}