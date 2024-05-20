import com.larkes.pokedexapp.database.PokemonDetailEntity
import com.larkes.pokedexapp.database.PokemonEntity
import kotlinx.serialization.json.Json
import ktor.PokemonKtorDataSource
import ktor.models.StatsDto
import mapper.toPokemon
import mapper.toPokemonAboutInfo
import mapper.toPokemonDetailEntity
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

        if((cachedPokemons.size < offset + limit) || refresh) {
            if (refresh) {
                pokemonSqlDelightDataSource.clearStorage()
            }
            val response = pokemonKtorDataSource.fetchPokemons(limit = limit, offset = offset)
            return response.results!!.map {
                val converted = it!!.toPokemon()
                pokemonSqlDelightDataSource.insertPokemon(
                    PokemonEntity(
                        id = converted.id,
                        name = converted.name
                    )
                )
                converted
            }
        } else {
            return cachedPokemons.subList(offset, offset + limit).map {
                it.toPokemon()
            }
        }
    }

    override suspend fun fetchPokemonAboutInfo(id: String, refresh: Boolean): PokemonAboutInfo {
        val cachedPokemon = pokemonDetailSqlSDelightDataSource.fetchPokemon(id)
        return if(cachedPokemon != null && refresh.not()) {
            cachedPokemon.toPokemonAboutInfo()
        }else{
            val response = pokemonKtorDataSource.fetchPokemonInfo(id)
            pokemonDetailSqlSDelightDataSource.cleanPokemon(id)
            pokemonDetailSqlSDelightDataSource.insertPokemonDetail(response.toPokemonDetailEntity(id))

            response.toPokemonAboutInfo()
        }
    }

    override suspend fun searchForPokemon(text: String): List<Pokemon> {
        return pokemonSqlDelightDataSource.fetchPokemons().filter { it.id.contains(text) || it.name.contains(text) }.map {
            it.toPokemon()
        }
    }

}