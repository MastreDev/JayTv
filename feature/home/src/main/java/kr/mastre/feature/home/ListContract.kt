package kr.mastre.feature.home

import kr.mastre.playlist.Playable

data class ViewState(
    val playList: List<Playable>,
)

sealed interface ViewEffect {
}