package kr.mastre.playlist.data

import io.reactivex.rxjava3.core.Single

interface PlaylistRemoteDataSource {

    fun fetchPlayList() : Single<List<PlayableDto>>
}