package list.models

import models.Pokemon

data class PokemonListViewState(
    val list:List<PokemonItem> = listOf(),
    val isLoading:Boolean = false,
    val error:String = "",
    val selectedPokemon:String? = null,
    val offset:Int = 5
)