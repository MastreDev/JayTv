package kr.mastre.feature.player

import androidx.lifecycle.SavedStateHandle
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
internal class PlayerViewModel @Inject constructor(
    val getPlayList: GetPlayListUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel(), ContainerHost<ViewState, ViewEffect> {

    private val args = PlayerArgs(savedStateHandle)

    override val container: Container<ViewState, ViewEffect> = container(ViewState(_playList = listOf())) {
        val result = getPlayList.invoke(GetPlayListUseCase.Params()).await()
        reduce { state.copy(_playList = result, currentPlaying = MyPlay(rawUri = args.uri, thumbnail = args.uri)) }
    }

    fun onPlayableClick(playable: Playable) = intent {
        reduce { state.copy(currentPlaying = playable) }
    }

    data class MyPlay(override val rawUri: String, override val thumbnail: String?) : Playable

}