package kr.mastre.feature.home

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.rx3.await
import kr.mastre.playlist.GetPlayListUseCase
import kr.mastre.playlist.Playable
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class ListViewModel @AssistedInject constructor(
    private val getPlayList: GetPlayListUseCase,
    @Assisted private val navigatePlayer: (Playable) -> Unit,
) : ViewModel(), ContainerHost<ViewState, ViewEffect> {

    override val container: Container<ViewState, ViewEffect> = container(ViewState(listOf())) {
        val result = getPlayList.invoke(GetPlayListUseCase.Params()).await()
        reduce { state.copy(playList = result) }
    }

    fun onItemClick(playItem: Playable) {
        navigatePlayer.invoke(playItem)
    }

    @AssistedFactory
    interface Factory {
        fun create(navigatePlayer: (Playable) -> Unit): ListViewModel
    }

}

