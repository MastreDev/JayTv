package kr.mastre.feature.home

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kr.mastre.playlist.Playable
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun ListScreen(vm: ListViewModel, onNavigateToPlayer: (Playable) -> Unit) {
    val state by vm.collectAsState()
    PlayList(
        modifier = Modifier.fillMaxWidth(),
        playlist = { state.playList },
        onItemClick = { vm.onItemClick(it) }
    )
    vm.collectSideEffect {
        when(it) {
            is ViewEffect.NavigateToPlayer -> onNavigateToPlayer(it.playable)
        }
    }
}

@Composable
internal fun PlayList(modifier: Modifier = Modifier, playlist: () -> List<Playable>, onItemClick: (Playable) -> Unit) {
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