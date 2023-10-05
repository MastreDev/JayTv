package kr.mastre.feature.home

import kr.mastre.playlist.Playable

internal data class ViewState(
    val playList: List<Playable>,
)

internal sealed interface ViewEffect {
    data class NavigateToPlayer(val playable: Playable) : ViewEffect
}