package kr.mastre.playlist.data

import kotlinx.serialization.Serializable
import kr.mastre.playlist.Playable

@Serializable
internal data class FirebasePlayItemDto(val uri : String, val thumb: String) : Playable {

    override val rawUri: String get() = uri
    override val thumbnail: String get() = thumb

}

@Serializable
internal data class GetPlayListResponse(val playlist : List<FirebasePlayItemDto>)