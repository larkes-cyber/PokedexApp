package list.models

sealed class PokemonListEvent {
    data class PokemonClicked(val id:String):PokemonListEvent()
    data object EndScrolled:PokemonListEvent()
    data class SearchEntered(val text:String):PokemonListEvent()
}