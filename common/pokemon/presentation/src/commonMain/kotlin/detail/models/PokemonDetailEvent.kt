package detail.models

sealed class PokemonDetailEvent {
    data class LoadPokemonInfo(val id:String):PokemonDetailEvent()
    data object BackArrowClicked:PokemonDetailEvent()

}