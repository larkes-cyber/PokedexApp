package list

import PokemonRepository
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CMutableStateFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import di.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import list.models.PokemonItem
import list.models.PokemonListAction
import list.models.PokemonListEvent
import list.models.PokemonListViewState

class PokemonListViewModel:ViewModel() {

    private val pokemonRepository:PokemonRepository = Inject.di.get()


    private val _pokemonList:CMutableStateFlow<List<PokemonItem>> = MutableStateFlow(emptyList<PokemonItem>()).cMutableStateFlow()
    val pokemonList:CStateFlow<List<PokemonItem>> = _pokemonList.cStateFlow()

    private val _isLoading:CMutableStateFlow<Boolean> = MutableStateFlow(false).cMutableStateFlow()
    val isLoading:CStateFlow<Boolean> = _isLoading.cStateFlow()

    private val _error:CMutableStateFlow<String> = MutableStateFlow("").cMutableStateFlow()
    val error:CStateFlow<String> = _error.cStateFlow()

    private val _offset:CMutableStateFlow<Int> = MutableStateFlow(5).cMutableStateFlow()

    private val _selectedPokemon:CMutableStateFlow<String?> = MutableStateFlow<String?>(null).cMutableStateFlow()
    val selectedPokemon:CStateFlow<String?> = _selectedPokemon.cStateFlow()

    private val _viewAction = Channel<PokemonListAction>()
    val viewAction: CFlow<PokemonListAction> get() = _viewAction.receiveAsFlow().cFlow()

    init {
        fetchNewPokemons()
    }

   private fun fetchNewPokemons(refresh:Boolean = false){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val pokemons = pokemonRepository.fetchPokemons(5, _offset.value, refresh)
                _pokemonList.value = pokemons.map {PokemonItem(
                    name = it.name,
                    id = it.id,
                    imageSrc = it.imageUrl
                   )
                }
                _offset.value += 5
            }catch (e:Exception){
                _error.value = e.message ?: ""
            }finally {
                _isLoading.value = false
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
        _selectedPokemon.value = id
        _viewAction.trySend(PokemonListAction.OpenPokemonDetail)
    }

}