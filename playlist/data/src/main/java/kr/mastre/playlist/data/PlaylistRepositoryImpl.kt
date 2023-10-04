package kr.mastre.playlist.data

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.toObservable
import kotlinx.coroutines.rx3.rxSingle
import kr.mastre.playlist.Playable
import kr.mastre.playlist.PlaylistRepository
import javax.inject.Inject

internal class PlaylistRepositoryImpl @Inject constructor(
    private val remoteSource: PlaylistRemoteDataSource,
) : PlaylistRepository {

    override fun getPlayList(): Single<List<Playable>> {
        return remoteSource
            .fetchPlayList()
            .flatMapObservable { it.toObservable() }
            .cast(Playable::class.java)
            .toList()
    }
}