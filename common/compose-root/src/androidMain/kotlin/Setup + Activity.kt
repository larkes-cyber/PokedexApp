import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import navigation.Navigation

fun ComponentActivity.setupThemedNavigation(){


    setContent {
        val navController = rememberNavController()
        Navigation(navController)
    }

}