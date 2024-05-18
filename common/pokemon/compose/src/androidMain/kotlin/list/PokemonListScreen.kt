package list

import NavigationTree
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.icerock.moko.mvvm.flow.compose.observeAsActions
import list.models.PokemonListAction

@Composable
fun PokemonListScreen(
    navController: NavController
) {

    val viewModel: PokemonListViewModel = viewModel()

    val viewState = viewModel.viewState.collectAsState()

    PokemonListView(viewState.value){
        viewModel.onEvent(it)
    }

    viewModel.viewAction.observeAsActions {action ->
        when(action){
            is PokemonListAction.OpenPokemonDetail -> {
                navController.navigate(NavigationTree.Pokemon.List.name)
            }
            else -> {}
        }
    }

}