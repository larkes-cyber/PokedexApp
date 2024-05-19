package detail.models

import models.PokemonAboutInfo

data class PokemonDetailViewState(
    val pokemonAboutInfo: PokemonAboutInfo? = null,
    val isLoading:Boolean = false,
)