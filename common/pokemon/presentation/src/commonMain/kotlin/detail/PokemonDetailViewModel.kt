package detail

import PokemonRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import detail.models.PokemonDetailAction
import detail.models.PokemonDetailEvent
import detail.models.PokemonDetailViewState
import di.Inject
import kotlinx.coroutines.launch

class PokemonDetailViewModel:BaseSharedViewModel<PokemonDetailViewState, PokemonDetailAction, PokemonDetailEvent>(
    initialState = PokemonDetailViewState()
) {
    private val pokemonRepository:PokemonRepository = Inject.di.get()

    override fun obtainEvent(viewEvent: PokemonDetailEvent) {
        when(viewEvent){
            is PokemonDetailEvent.LoadPokemonInfo -> {
                obtainLoadPokemonDetail(viewEvent.id)
            }
            is PokemonDetailEvent.BackArrowClicked -> {
                obtainBackArrowClicked()
            }
        }
    }

    private fun obtainBackArrowClicked() {
        viewAction = PokemonDetailAction.ScreenBack
    }

    private fun obtainLoadPokemonDetail(id: String) {
        viewModelScope.launch {
            try {
                viewState = viewState.copy(isLoading = true)
                val info = pokemonRepository.fetchPokemonAboutInfo(id)
                viewState = viewState.copy(pokemonAboutInfo = info)
            }catch (e:Exception){
                println(e)
            }finally {
                viewState = viewState.copy(isLoading = false)
            }
        }
    }


}