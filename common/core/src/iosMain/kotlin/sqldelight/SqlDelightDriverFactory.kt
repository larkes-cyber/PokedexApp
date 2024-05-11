package sqldelight

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import platform.PlatformConfiguration
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.cash.sqldelight.async.coroutines.synchronous



actual class SqlDelightDriverFactory actual constructor(private val platformConfiguration: PlatformConfiguration){
    actual fun makeDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>, name:String): SqlDriver {
        return NativeSqliteDriver(schema.synchronous(), name)
    }
}