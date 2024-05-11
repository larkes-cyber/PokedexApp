import com.larkes.pokedexapp.database.PokemonEntity
import ktor.PokemonKtorDataSource
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
                atk = cachedPokemon.atk?.toInt(),
                def = cachedPokemon.def?.toInt(),
                height = cachedPokemon.height?.toFloat(),
                hp = cachedPokemon.hp?.toInt(),
                spAtk = cachedPokemon.spAtk?.toInt(),
                spDef = cachedPokemon.spDef?.toInt(),
                spd = cachedPokemon.spd?.toInt(),
                species = cachedPokemon.species,
                types = cachedPokemon.types?.split(",") ?: emptyList(),
                weight = cachedPokemon.weight?.toFloat()
            )
        }else{
            val response = pokemonKtorDataSource.fetchPokemonInfo(id)

            val info = PokemonAboutInfo(
                name = response.name ?: "",
                abilities = response.abilities.map { it?.ability?.name ?: "" },
                atk = response.stats[0].stat.
            )
        }
    }

}