package kr.mastre.feature.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.mastre.playlist.Playable

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(onNavigateToPlayer: (Playable) -> Unit) {
    composable(HOME_ROUTE) {
        ListScreen(vm = hiltViewModel(), onNavigateToPlayer = onNavigateToPlayer)
    }
}