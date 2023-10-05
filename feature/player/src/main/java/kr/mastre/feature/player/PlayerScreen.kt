package kr.mastre.feature.player

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kr.mastre.playlist.Playable
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun PlayerScreen(vm: PlayerViewModel) {
    val state by vm.collectAsState()

    Column {
        VideoPlayer(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
                .background(Color.Black),
            playable = { state.currentPlaying }
        )
        VideoPlayList(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
                .background(Color.Gray),
            playlist = { state.playList },
            onItemClick = { vm.onPlayableClick(it) }
        )
    }
}

@Composable
internal fun VideoPlayer(modifier: Modifier = Modifier, playable: () -> Playable?) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
            .apply {
                playWhenReady = true
            }
    }

    playable()?.let {
        exoPlayer.setMediaItem(MediaItem.fromUri(it.rawUri))
        exoPlayer.prepare()
    }


    AndroidView(modifier = modifier, factory = {
        PlayerView(it).apply {
            player = exoPlayer
            layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    })

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }
}

@Composable
internal fun VideoPlayList(modifier: Modifier = Modifier, playlist: () -> List<Playable>, onItemClick: (Playable) -> Unit) {
    LazyColumn(modifier) {
        items(key = { it.rawUri }, items = playlist()) {
            Cell(
                Modifier
                    .background(Color.White)
                    .clickable { onItemClick(it) },
                uri = it.rawUri,
                thumbnail = it.thumbnail
            )
        }
    }
}

@Composable
internal fun Cell(modifier: Modifier, uri: String, thumbnail: String?) {
    Column(modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(thumbnail)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )
        Text(
            text = uri,
            modifier = Modifier.padding(horizontal = 20.dp),
            maxLines = 1
        )
    }
}

@Preview
@Composable
internal fun PreviewPlayList() {
}