import models.Pokemon
import models.PokemonAboutInfo

interface PokemonRepository {
    suspend fun fetchPokemons(limit:Int, offset:Int, refresh:Boolean = false):List<Pokemon>
    suspend fun fetchPokemonAboutInfo(id:String, refresh: Boolean = false):PokemonAboutInfo
}