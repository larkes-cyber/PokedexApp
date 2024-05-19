package list

import NavigationTree
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import list.models.PokemonListAction

@Composable
fun PokemonListScreen(
    navController: NavController
) {

   ViewModel(
       factory = {PokemonListViewModel()}
   ){viewModel ->

       val viewState = viewModel.viewStates().observeAsState()
       val viewAction = viewModel.viewActions().observeAsState()

       PokemonListView(viewState.value){
           viewModel.obtainEvent(it)
       }

       when(viewAction.value){
           is PokemonListAction.OpenPokemonDetail -> {
               navController.navigate(NavigationTree.Pokemon.List.name)
           }
           else -> {}
       }
   }


}