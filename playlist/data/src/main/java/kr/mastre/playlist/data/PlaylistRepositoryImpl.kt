package kr.mastre.playlist.data

import io.reactivex.rxjava3.core.Single
import kr.mastre.jaytv.playlist.domain.Playable
import kr.mastre.jaytv.playlist.domain.PlaylistRepository

internal class PlaylistRepositoryImpl(
    private val remoteSource: FirebaseRemoteSource,
) : PlaylistRepository {

    override fun getPlayList(): Single<List<Playable>> {
        return remoteSource.fetchPlayList()
    }

}