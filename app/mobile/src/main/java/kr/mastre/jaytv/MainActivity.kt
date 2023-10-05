package kr.mastre.jaytv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.mastre.jaytv.navigation.MainNavigator
import kr.mastre.jaytv.ui.theme.JayTvTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            JayTvTheme {
                MainNavigator(navController = navController)
            }
        }
        onBackPressedDispatcher.addCallback {
            finish()
        }
    }
}