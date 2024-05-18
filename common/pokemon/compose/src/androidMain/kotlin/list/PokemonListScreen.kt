package list

import NavigationTree
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.icerock.moko.mvvm.flow.compose.observeAsActions
import list.models.PokemonListAction
import list.models.PokemonListViewState

@Composable
fun PokemonListScreen(
    navController: NavController
) {

    val viewModel: PokemonListViewModel = viewModel()

    val pokemonList by viewModel.pokemonList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    PokemonListView(
        PokemonListViewState(
            list = pokemonList,
            isLoading = isLoading,
            error = error
        )
    ){
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