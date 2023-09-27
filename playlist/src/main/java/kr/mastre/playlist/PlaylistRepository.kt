package kr.mastre.playlist

import io.reactivex.rxjava3.core.Single

interface PlaylistRepository {
    fun getPlayList(): Single<List<Playable>>
}