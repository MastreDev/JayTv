package kr.mastre.jaytv.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dagger.hilt.android.EntryPointAccessors
import kr.mastre.feature.home.ListScreen
import kr.mastre.feature.player.PlayerScreen
import kr.mastre.jaytv.di.AssistedViewModelFactoryProvider

@Composable
fun JayNavigator(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            ListScreen(assistViewModel { provider ->
                provider.listViewModelFactory().create {
                    println("it : $it")
                    navController.navigate("player")
                }
            })
        }
        composable("player") { PlayerScreen(hiltViewModel()) }
    }
}

@Suppress("UNCHECKED_CAST")
@Composable
inline fun <reified VM : ViewModel> assistViewModel(
    viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    },
    crossinline create: (provider: AssistedViewModelFactoryProvider) -> VM,
): VM {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        AssistedViewModelFactoryProvider::class.java
    )
    return viewModel(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return create(factory) as T
            }
        }
    )
}