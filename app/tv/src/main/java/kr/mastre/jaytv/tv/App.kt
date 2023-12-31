package kr.mastre.jaytv.tv

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.util.Stack

@Composable
fun App() {
    val navController = rememberNavController()
//    val showDetails: (Movie) -> Unit = {
//        navController.navigate("/movie/${it.id}")
//    }

    NavHost(navController = navController, startDestination = "/") {
        composable("/") {
//            CatalogBrowser(onMovieSelected = showDetails)
        }
        composable(
            route = "/movie/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.LongType
            })
        ) {
            val stack = Stack<String>()
            val char = '1'
//            if(it.arguments?.getLong("id") == null){
//                throw DetailsError.NoIdSpecified
//            }
//            DetailsScreen()
        }
    }
}