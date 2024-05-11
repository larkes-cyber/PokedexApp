import com.larkes.pokedexapp.database.PokemonDetailEntity
import com.larkes.pokedexapp.database.PokemonEntity
import kotlinx.serialization.json.Json
import ktor.PokemonKtorDataSource
import ktor.models.StatsDto
import models.Pokemon
import models.PokemonAboutInfo
import sqldelight.PokemonDetailSqlSDelightDataSource
import sqldelight.PokemonSqlDelightDataSource

class PokemonRepositoryImpl(
    private val pokemonKtorDataSource: PokemonKtorDataSource,
    private val pokemonSqlDelightDataSource: PokemonSqlDelightDataSource,
    private val pokemonDetailSqlSDelightDataSource: PokemonDetailSqlSDelightDataSource
):PokemonRepository {
    override suspend fun fetchPokemons(limit: Int, offset: Int, refresh:Boolean): List<Pokemon> {

        val cachedPokemons = pokemonSqlDelightDataSource.fetchPokemons()
        if((cachedPokemons.size < offset + limit) || refresh){
            val response = pokemonKtorDataSource.fetchPokemons(limit = limit, offset = offset)
            if(refresh){
                pokemonSqlDelightDataSource.clearStorage()
            }
            return response.results!!.map {

                val splitedUrl = it?.url?.split("/")!!
                val lastIndex = it.url.split("/").lastIndex
                val id = splitedUrl[lastIndex - 1]

                val converted = Pokemon(
                    id = id,
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png",
                    name = it.name!!
                )
                pokemonSqlDelightDataSource.insertPokemon(
                    PokemonEntity(
                    id = converted.id,
                     name = converted.name
                 )
                )
                converted
            }
        }else{
            return cachedPokemons.subList(offset, offset+limit).map {
                Pokemon(
                    id = it.id,
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${it.id}.png",
                    name = it.name
                    )
            }
        }

    }

    override suspend fun fetchPokemonAboutInfo(id: String, refresh: Boolean): PokemonAboutInfo {
        val cachedPokemon = pokemonDetailSqlSDelightDataSource.fetchPokemon(id)
        if(cachedPokemon != null && refresh.not()) {
            return PokemonAboutInfo(
                name = cachedPokemon.name,
                abilities = cachedPokemon.abilities?.split(",") ?: emptyList(),
                height = cachedPokemon.height?.toInt(),
                species = cachedPokemon.species,
                types = cachedPokemon.types?.split(",") ?: emptyList(),
                weight = cachedPokemon.weight?.toInt(),
                stat = Json.decodeFromString(StatsDto.serializer(), cachedPokemon.stat ?: "[]").list
            )
        }else{
            val response = pokemonKtorDataSource.fetchPokemonInfo(id)


            val stat:List<Pair<String, Int>> = response.stats?.map {
                Pair(it!!.stat!!.name!!, it.baseStat!!)
            } ?: emptyList()

            val info = PokemonAboutInfo(
                name = response.name ?: "",
                abilities = response.abilities?.map { it?.ability?.name ?: "" } ?: listOf(),
                height = response.height,
                species = response.species?.name ?: "",
                stat = stat,
                types = response.types?.map { it!!.type!!.name!! } ?: listOf(),
                weight = response.weight
            )

            pokemonDetailSqlSDelightDataSource.cleanPokemon(id)

            pokemonDetailSqlSDelightDataSource.insertPokemonDetail(
                PokemonDetailEntity(
                    id = id,
                    name = response.name ?: "",
                    abilities = info.abilities.joinToString(","),
                    height = response.height.toString(),
                    species = response.species?.name ?: "",
                    types = info.types.joinToString(","),
                    weight = response.weight.toString(),
                    stat = Json.encodeToString(StatsDto.serializer(), StatsDto(stat))
                )
            )

            return info
        }
    }

}