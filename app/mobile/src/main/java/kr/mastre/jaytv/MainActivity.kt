package kr.mastre.jaytv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import coil.ImageLoader
import coil.decode.VideoFrameDecoder
import coil.imageLoader
import dagger.hilt.android.AndroidEntryPoint
import kr.mastre.feature.player.PlayerScreen
import kr.mastre.jaytv.ui.theme.JayTvTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JayTvTheme {
                PlayerScreen()
            }
        }
        onBackPressedDispatcher.addCallback {
            finish()
        }
    }
}