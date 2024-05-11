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
            atk = pokemonDetailEntity.atk,
            def = pokemonDetailEntity.def,
            types = pokemonDetailEntity.types,
            height = pokemonDetailEntity.height,
            hp = pokemonDetailEntity.hp,
            name = pokemonDetailEntity.name,
            spAtk = pokemonDetailEntity.spAtk,
            spDef = pokemonDetailEntity.spDef,
            spd = pokemonDetailEntity.spd,
            species = pokemonDetailEntity.species,
            weakness = pokemonDetailEntity.weakness,
            weight = pokemonDetailEntity.weight
        )
    }

    suspend fun fetchPokemon(id:String):PokemonDetailEntity?{
        return queries.fetchPokemon(id).executeAsOneOrNull()
    }

    suspend fun cleanPokemon(id:String){
        queries.clearPokemon(id)
    }

}