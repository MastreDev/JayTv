package kr.mastre.feature.player

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

private const val ROUTE = "player"
private const val KEY_ARGS = "playableUri"

internal class PlayerArgs(val uri: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(checkNotNull(savedStateHandle[KEY_ARGS]) as String)

}

fun NavGraphBuilder.playerScreen() {
    composable("$ROUTE/{$KEY_ARGS}", arguments = listOf(
        navArgument(KEY_ARGS) { type = NavType.StringType }
    )) {
        PlayerScreen(hiltViewModel())
    }
}

fun NavController.navigateToPlayer(uri: String) {
    val encodedUri = URLEncoder.encode(uri, StandardCharsets.UTF_8.toString())
    this.navigate("$ROUTE/$encodedUri")
}