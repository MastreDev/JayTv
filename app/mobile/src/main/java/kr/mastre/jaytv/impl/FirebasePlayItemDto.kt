package kr.mastre.jaytv.impl

import kotlinx.serialization.Serializable
import kr.mastre.playlist.data.PlayableDto

@Serializable
internal data class FirebasePlayItemDto(val uri: String, val thumb: String) : PlayableDto {

    override val rawUri: String get() = uri
    override val thumbnail: String get() = thumb

}