import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.larkes.pokedexapp.PokedexDatabase
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import ktor.PokemonKtorDataSource
import org.junit.Before
import org.junit.Test
import sqldelight.PokemonDetailSqlSDelightDataSource
import sqldelight.PokemonSqlDelightDataSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokemonRepositoryTest {

    private lateinit var repository:PokemonRepository

    @Before
    fun before(){
        runBlocking {
            val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
            PokedexDatabase.Schema.create(driver).await()
            val db = PokedexDatabase(driver)
            val httpClient = HttpClient(CIO.create()) {
                install(ContentNegotiation) {
                    json(Json{
                        ignoreUnknownKeys = true
                    })
                }
                defaultRequest {
                    url("https://pokeapi.co")
                }
            }
            val sqlSource = PokemonSqlDelightDataSource(db)
            val ktorSource = PokemonKtorDataSource(httpClient)
            val sqlSource2 = PokemonDetailSqlSDelightDataSource(db)
            repository = PokemonRepositoryImpl(ktorSource, sqlSource, sqlSource2)
        }
    }

    @Test
    fun `Should fetch fresh pokemons`(){
       runBlocking {
           val limit = 5
           val offset = 5
           println("#### fetch started ####")
           val pokemons = repository.fetchPokemons(limit = limit, offset = offset, refresh = false)
           println("#### fetch ended ####")
           println(pokemons)
           pokemons.forEach {
               assertTrue(it.id.isNotEmpty())
           }
           assertEquals(pokemons.size, limit)

       }

    }

    @Test
    fun `Should fetch next pokemons`(){
        val limit = 5
        var offset = 5
        runBlocking {
            val pokemons1 = repository.fetchPokemons(limit, offset, refresh = true)
            offset += 5
            val pokemons2 = repository.fetchPokemons(limit, offset, refresh = true)
            pokemons1.forEachIndexed { index, pokemon ->
                assertTrue(pokemon != pokemons2[index])
            }
        }
    }

    @Test
    fun `Should fetch pokemon detail info`(){
        runBlocking {
            val id = "35"
            val detail = repository.fetchPokemonAboutInfo(id)
            println(detail)
            assertTrue(detail.name == "clefairy")
        }
    }

    @Test
    fun `Should fetch different pokemons detail info`(){
        runBlocking {
            (0..40).forEach{
                println(repository.fetchPokemonAboutInfo(it.toString()))
            }
        }
    }

}