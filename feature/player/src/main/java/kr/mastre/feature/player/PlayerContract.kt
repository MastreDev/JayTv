package kr.mastre.feature.player

import kr.mastre.playlist.Playable

internal data class ViewState(
    var currentPlaying: Playable? = null,
    private val _playList: List<Playable>,
) {
    val playList get() = _playList.filter { it.rawUri != currentPlaying?.rawUri }
}

internal sealed interface ViewEffect {

}