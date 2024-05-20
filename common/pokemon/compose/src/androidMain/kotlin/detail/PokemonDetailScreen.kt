package detail

import NavigationTree
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import detail.models.PokemonDetailAction
import detail.models.PokemonDetailEvent

@Composable
fun PokemonDetailScreen(navController: NavController, id:String) {


    ViewModel(factory = { PokemonDetailViewModel() }){viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()

        LaunchedEffect(Unit){
            viewModel.obtainEvent(PokemonDetailEvent.LoadPokemonInfo(id))
        }

        PokemonDetailView(viewState.value){
            viewModel.obtainEvent(it)
        }

        when(viewAction.value){
            is PokemonDetailAction.ScreenBack -> {
                navController.navigate(NavigationTree.Pokemon.List.name)
            }
            else -> {}
        }
    }

}