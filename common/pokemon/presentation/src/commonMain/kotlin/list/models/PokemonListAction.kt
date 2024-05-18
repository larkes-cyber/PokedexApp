package list.models

sealed class PokemonListAction{
    data object OpenPokemonDetail:PokemonListAction()
}