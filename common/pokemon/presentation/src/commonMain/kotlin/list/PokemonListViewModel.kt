package list

import PokemonRepository
import dev.icerock.moko.mvvm.flow.CMutableStateFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import di.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import list.models.PokemonItem
import list.models.PokemonListAction
import list.models.PokemonListEvent
import list.models.PokemonListViewState

class PokemonListViewModel:ViewModel() {

    private val pokemonRepository:PokemonRepository = Inject.di.get()

    private val _viewState:CMutableStateFlow<PokemonListViewState> = MutableStateFlow(PokemonListViewState()).cMutableStateFlow()
    val viewState:CStateFlow<PokemonListViewState> = _viewState.cStateFlow()

    private val _viewAction:CMutableStateFlow<PokemonListAction?> = MutableStateFlow<PokemonListAction?>(null).cMutableStateFlow()
    val viewAction:CStateFlow<PokemonListAction?> = _viewAction.cStateFlow()

    init {
        fetchNewPokemons()
    }

   private fun fetchNewPokemons(refresh:Boolean = false){
        viewModelScope.launch {
            _viewState.value = viewState.value.copy(isLoading = true)
            try {
                val pokemons = pokemonRepository.fetchPokemons(5, viewState.value.offset, refresh)
                _viewState.value = viewState.value.copy(
                    list = pokemons.map {PokemonItem(
                                name = it.name,
                                id = it.id,
                                imageSrc = it.imageUrl
                        )
                    },
                    offset = viewState.value.offset + 5
                )
            }catch (e:Exception){
                _viewState.value = viewState.value.copy(error = e.message ?: "")
            }finally {
                _viewState.value = viewState.value.copy(isLoading = false)
            }
        }
    }

    fun onEvent(event:PokemonListEvent){

        when(event){
            is PokemonListEvent.PokemonClicked -> {
                obtainPokemonClicked(id = event.id)
            }
        }

    }

    private fun obtainPokemonClicked(id:String) {
        _viewState.value = viewState.value.copy(selectedPokemon = id)
        _viewAction.value = PokemonListAction.OpenPokemonDetail
    }

}