package kr.mastre.feature.player

import kr.mastre.jaytv.playlist.domain.Playable

data class PlayerViewState(
    val playList: List<Playable>
)

sealed interface PlayerViewEffect{

}