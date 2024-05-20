package mapper

import com.larkes.pokedexapp.database.PokemonDetailEntity
import com.larkes.pokedexapp.database.PokemonEntity
import kotlinx.serialization.json.Json
import ktor.models.ResultsItem
import ktor.models.StatsDto
import ktor.models.pokemon_detail.PokemonDetailDto
import models.Pokemon
import models.PokemonAboutInfo

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

fun PokemonDetailEntity.toPokemonAboutInfo():PokemonAboutInfo{
    return PokemonAboutInfo(
        name = name,
        abilities = abilities?.split(",") ?: emptyList(),
        height = height?.toInt(),
        species = species,
        types = types?.split(",") ?: emptyList(),
        weight = weight?.toInt(),
        stat = Json.decodeFromString(StatsDto.serializer(), stat ?: "[]").list,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    )
}

fun PokemonDetailDto.toPokemonAboutInfo():PokemonAboutInfo{
    val stat:List<Pair<String, Int>> = stats?.map {
        Pair(it!!.stat!!.name!!, it.baseStat!!)
    } ?: emptyList()

    return PokemonAboutInfo(
        name = name ?: "",
        abilities = abilities?.map { it?.ability?.name ?: "" } ?: listOf(),
        height = height,
        species = species?.name ?: "",
        stat = stat,
        types = types?.map { it!!.type!!.name!! } ?: listOf(),
        weight = weight,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    )
}

fun PokemonDetailDto.toPokemonDetailEntity(id:String):PokemonDetailEntity{
    val stat:List<Pair<String, Int>> = stats?.map {
        Pair(it!!.stat!!.name!!, it.baseStat!!)
    } ?: emptyList()
    return PokemonDetailEntity(
        id = id,
        name =name ?: "",
        abilities = (abilities?.map { it?.ability?.name ?: "" } ?: listOf()).joinToString(""),
        height = height.toString(),
        species = species?.name ?: "",
        types = (types?.map { it!!.type!!.name!! } ?: listOf()).joinToString(","),
        weight = weight.toString(),
        stat = Json.encodeToString(StatsDto.serializer(), StatsDto(stat))
    )
}