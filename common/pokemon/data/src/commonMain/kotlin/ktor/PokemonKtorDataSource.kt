package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import ktor.models.PokemonDetailDto
import ktor.models.PokemonListDto

class PokemonKtorDataSource(
    private val ktorClient:HttpClient
) {

    suspend fun fetchPokemons(limit:Int, offset:Int):PokemonListDto{
        val response = ktorClient.get{
            contentType(ContentType.Application.Json)
            url {
                path(POKEMON_LIST)
                parameter("offset",offset)
                parameter("limit", limit)
             }
        }
        return response.body()
    }

    suspend fun fetchPokemonInfo(id:String): PokemonDetailDto {
        val response = ktorClient.get{
            contentType(ContentType.Application.Json)
            url {
                path("$POKEMON_LIST/$id")
            }
        }
        return response.body()
    }

    companion object{
        private const val POKEMON_LIST = "api/v2/pokemon"
    }

}