package kr.mastre.jaytv.impl

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPlayListResponse(val playlist: List<FirebasePlayItemDto>)