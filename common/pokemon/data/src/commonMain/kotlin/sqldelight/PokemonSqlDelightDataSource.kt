package sqldelight

import com.larkes.pokedexapp.PokedexDatabase
import com.larkes.pokedexapp.database.PokemonDetailEntity
import com.larkes.pokedexapp.database.PokemonEntity

class PokemonSqlDelightDataSource(
    private val db: PokedexDatabase
) {

    private val queries = db.pokemonQueries

    suspend fun insertPokemon(pokemonEntity: PokemonEntity){
        queries.insertPokemon(
            id = pokemonEntity.id,
            name = pokemonEntity.name
        )
    }

    suspend fun fetchPokemons():List<PokemonEntity>{
        return queries.fetchPokemons().executeAsList()
    }

    suspend fun clearStorage(){
        queries.clearStorage()
    }

}