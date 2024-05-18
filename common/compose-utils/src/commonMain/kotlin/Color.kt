import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PokedexColors(
    val primaryBackground: Color,
    val primaryTitle:Color,
    val primaryText:Color,
    val secondaryPrimaryTitle:Color

)

val palette = PokedexColors(
    primaryBackground = Color.White,
    primaryTitle = Color.Black,
    primaryText = Color.LightGray,
    secondaryPrimaryTitle = Color.White
)

val LocalColorProvider = staticCompositionLocalOf<PokedexColors> {
    error("")
}