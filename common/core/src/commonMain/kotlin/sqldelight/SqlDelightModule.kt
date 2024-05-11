package sqldelight

import com.larkes.pokedexapp.PokedexDatabase
import org.koin.dsl.module

internal val sqlDelightModule = module {
    single { PokedexDatabase(SqlDelightDriverFactory(get()).makeDriver(PokedexDatabase.Schema, "wallet")) }
}