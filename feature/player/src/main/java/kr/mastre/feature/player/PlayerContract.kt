package kr.mastre.feature.player

import kr.mastre.playlist.Playable

data class PlayerViewState(
    val playList: List<Playable>
)

sealed interface PlayerViewEffect{

}