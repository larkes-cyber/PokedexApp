package mapper

import com.larkes.pokedexapp.database.PokemonEntity
import ktor.models.ResultsItem
import models.Pokemon

fun ResultsItem.toPokemon():Pokemon{
    val splitedUrl = url?.split("/")!!
    val lastIndex = url.split("/").lastIndex
    val id = splitedUrl[lastIndex - 1]
    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    return Pokemon(
        imageUrl = imageUrl,
        id = id,
        name = name ?: ""
    )
}

fun PokemonEntity.toPokemon():Pokemon{

    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    return Pokemon(
        imageUrl = imageUrl,
        id = id,
        name = name ?: ""
    )
}