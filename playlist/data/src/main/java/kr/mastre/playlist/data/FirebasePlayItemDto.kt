package kr.mastre.playlist.data

import kotlinx.serialization.Serializable
import kr.mastre.jaytv.playlist.domain.Playable

@Serializable
internal data class FirebasePlayItemDto(val uri : String) : Playable {

    override val rawUri: String get() = uri

}

@Serializable
internal data class GetPlayListResponse(val playlist : List<FirebasePlayItemDto>)