package list.models

sealed class PokemonListEvent {
    data class PokemonClicked(val id:String):PokemonListEvent()
}