package kr.mastre.jaytv.playlist.domain

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPlayListUseCase constructor(@Inject private val repository: PlaylistRepository) : SingleUseCase<GetPlayListUseCase.Params, List<Playable>> {

    override fun invoke(params: Params): Single<List<Playable>> {
        return repository.getPlayList()
    }

    data class Params(val none: Unit = Unit)

}