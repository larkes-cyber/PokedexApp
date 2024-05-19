package list

import PokemonRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import list.models.PokemonItem
import list.models.PokemonListAction
import list.models.PokemonListEvent
import list.models.PokemonListViewState

class PokemonListViewModel:BaseSharedViewModel<PokemonListViewState, PokemonListAction, PokemonListEvent>(
    initialState = PokemonListViewState()
) {

    private val pokemonRepository:PokemonRepository = Inject.di.get()


    override fun obtainEvent(viewEvent: PokemonListEvent) {
        when(viewEvent){
            is PokemonListEvent.PokemonClicked -> {
                obtainPokemonClicked(id = viewEvent.id)
            }
            is PokemonListEvent.EndScrolled -> {
                fetchNewPokemons()
            }
            is PokemonListEvent.SearchEntered -> {
                obtainSearchEntered(viewEvent.text)
            }
        }
    }

    private fun obtainSearchEntered(text:String) {
        viewModelScope.launch {
            viewState = viewState.copy(searchText = text)
            if(text.isEmpty()){
                viewState = viewState.copy(offset = 0, list = emptyList())
                fetchNewPokemons()
            }else{
                viewState = viewState.copy(isLoading = true)
                val list = pokemonRepository.searchForPokemon(text)
                viewState = viewState.copy(list = list.map {
                    PokemonItem(
                        name = it.name,
                        id = it.id,
                        imageSrc = it.imageUrl
                    )
                })
                viewState = viewState.copy(isLoading = false)
            }
        }
    }

    init {
        fetchNewPokemons()
    }

   private fun fetchNewPokemons(refresh:Boolean = false){
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            try {
                val pokemons = pokemonRepository.fetchPokemons(5, viewState.offset, refresh)
                viewState = viewState.copy(list = viewState.list + pokemons.map {PokemonItem(
                        name = it.name,
                        id = it.id,
                        imageSrc = it.imageUrl
                    )},
                    offset = viewState.offset + 5
                )
            }catch (e:Exception){
                println(e.message)
                viewState = viewState.copy(error = e.message ?: "")
            }finally {
                viewState = viewState.copy(isLoading = false)
            }
        }
    }


    private fun obtainPokemonClicked(id:String) {
        viewState = viewState.copy(selectedPokemon = id)
        viewAction = PokemonListAction.OpenPokemonDetail
    }

}