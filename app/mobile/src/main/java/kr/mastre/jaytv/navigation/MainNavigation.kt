package kr.mastre.jaytv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import kr.mastre.feature.home.HOME_ROUTE
import kr.mastre.feature.home.homeScreen
import kr.mastre.feature.player.navigateToPlayer
import kr.mastre.feature.player.playerScreen

@Composable
fun MainNavigator(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME_ROUTE) {
        homeScreen {
            navController.navigateToPlayer(it.rawUri)
        }
        playerScreen()
    }
}