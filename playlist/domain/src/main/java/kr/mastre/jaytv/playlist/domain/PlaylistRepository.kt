package kr.mastre.jaytv.playlist.domain

import io.reactivex.rxjava3.core.Single

interface PlaylistRepository {
    fun getPlayList(): Single<List<Playable>>
}