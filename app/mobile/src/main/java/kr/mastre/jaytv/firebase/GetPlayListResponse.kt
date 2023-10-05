package kr.mastre.jaytv.firebase

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPlayListResponse(val playlist: List<FirebasePlayItemDto>)