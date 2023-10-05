package kr.mastre.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.rx3.await
import kr.mastre.playlist.GetPlayListUseCase
import kr.mastre.playlist.Playable
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
internal class ListViewModel @Inject constructor(
    private val getPlayList: GetPlayListUseCase,
) : ViewModel(), ContainerHost<ViewState, ViewEffect> {

    override val container: Container<ViewState, ViewEffect> = container(ViewState(listOf())) {
        val result = getPlayList.invoke(GetPlayListUseCase.Params()).await()
        reduce { state.copy(playList = result) }
    }

    fun onItemClick(playable: Playable) {
        intent { postSideEffect(ViewEffect.NavigateToPlayer(playable)) }
    }
}

