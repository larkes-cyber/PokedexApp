package settings

import com.russhwolf.settings.Settings
import org.koin.dsl.module

internal val settingsModule = module {
    single { Settings() }
}