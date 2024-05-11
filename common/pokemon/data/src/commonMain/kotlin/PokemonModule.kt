import ktor.PokemonKtorDataSource
import org.koin.dsl.module
import sqldelight.PokemonSqlDelightDataSource

val pokemonModule = module {
    single { PokemonSqlDelightDataSource(get()) }
    single { PokemonKtorDataSource(get()) }
    single<PokemonRepository> { PokemonRepositoryImpl(get(), get()) }
}