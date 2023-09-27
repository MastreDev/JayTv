package kr.mastre.playlist.data

import io.reactivex.rxjava3.core.Single
import kr.mastre.playlist.Playable
import kr.mastre.playlist.PlaylistRepository
import javax.inject.Inject

internal class PlaylistRepositoryImpl @Inject constructor(
    private val remoteSource: FirebaseRemoteSource,
) : PlaylistRepository {

    override fun getPlayList(): Single<List<Playable>> {
        return remoteSource.fetchPlayList()
    }

}