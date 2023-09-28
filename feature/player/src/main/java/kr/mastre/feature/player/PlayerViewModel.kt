package kr.mastre.feature.player

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.rx3.await
import kr.mastre.playlist.GetPlayListUseCase
import kr.mastre.playlist.Playable
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    val getPlayList: GetPlayListUseCase,
) : ViewModel(), ContainerHost<PlayerViewState, PlayerViewEffect> {

    override val container: Container<PlayerViewState, PlayerViewEffect> = container(PlayerViewState(playList = listOf())) {
        val result = getPlayList.invoke(GetPlayListUseCase.Params()).await()
        reduce { state.copy(playList = result) }
    }

    fun onPlayableClick(playable: Playable) = intent {
        reduce { state.copy(currentPlaying = playable) }
    }

}