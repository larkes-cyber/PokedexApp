package sqldelight

import com.larkes.pokedexapp.PokedexDatabase
import com.larkes.pokedexapp.database.PokemonDetailEntity

class PokemonDetailSqlSDelightDataSource(
    private val db: PokedexDatabase

) {

    private val queries = db.pokemonDetailQueries

    suspend fun insertPokemonDetail(pokemonDetailEntity: PokemonDetailEntity){
        queries.insertPokemon(
            id = pokemonDetailEntity.id,
            abilities = pokemonDetailEntity.abilities,
            types = pokemonDetailEntity.types,
            height = pokemonDetailEntity.height,
            name = pokemonDetailEntity.name,
            species = pokemonDetailEntity.species,
            weight = pokemonDetailEntity.weight,
            stat = pokemonDetailEntity.stat
        )
    }

    suspend fun fetchPokemon(id:String):PokemonDetailEntity?{
        return queries.fetchPokemon(id).executeAsOneOrNull()
    }

    suspend fun cleanPokemon(id:String){
        queries.clearPokemon(id)
    }

}