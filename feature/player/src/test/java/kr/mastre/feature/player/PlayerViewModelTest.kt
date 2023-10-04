package kr.mastre.feature.player

import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.test.runTest
import kr.mastre.playlist.GetPlayListUseCase
import kr.mastre.playlist.Playable
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.orbitmvi.orbit.test.test

class PlayerViewModelTest {
    @Test
    fun `When init, call use case`() = runTest {
        val expectedResult = listOf<Playable>(mock())
        val useCase = mock<GetPlayListUseCase> {
            on { invoke(GetPlayListUseCase.Params()) } doReturn Single.just(expectedResult)
        }
        val vm = PlayerViewModel(getPlayList = useCase)
        vm.test(this) {
            runOnCreate()
            expectInitialState()
            expectState { copy(playList = expectedResult) }
        }
    }
}
