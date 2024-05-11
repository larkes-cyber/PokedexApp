import ktor.PokemonKtorDataSource
import org.koin.dsl.module
import sqldelight.PokemonDetailSqlSDelightDataSource
import sqldelight.PokemonSqlDelightDataSource

val pokemonModule = module {
    single { PokemonSqlDelightDataSource(get()) }
    single { PokemonKtorDataSource(get()) }
    single { PokemonDetailSqlSDelightDataSource(get()) }
    single<PokemonRepository> { PokemonRepositoryImpl(get(), get(), get()) }
}