import models.Pokemon
import models.PokemonAboutInfo
import models.PokemonStatInfo

interface PokemonRepository {
    suspend fun fetchPokemons(limit:Int, offset:Int, refresh:Boolean):List<Pokemon>
    suspend fun fetchPokemonAboutInfo(id:String):PokemonAboutInfo
    suspend fun fetchPokemonStatsInfo():PokemonStatInfo
}