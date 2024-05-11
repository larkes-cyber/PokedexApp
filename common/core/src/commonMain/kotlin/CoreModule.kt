import ktor.ktorModule
import settings.settingsModule
import sqldelight.sqlDelightModule

val coreModule = ktorModule + sqlDelightModule + settingsModule