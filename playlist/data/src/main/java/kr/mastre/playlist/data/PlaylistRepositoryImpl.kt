package kr.mastre.playlist.data

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.toObservable
import kr.mastre.jaytv.playlist.domain.Playable
import kr.mastre.jaytv.playlist.domain.PlaylistRepository

internal class PlaylistRepositoryImpl : PlaylistRepository {

    override fun getPlayList(): Single<List<Playable>> {
        return raw.map { PlayDto(it) }.toObservable().cast(Playable::class.java).toList()
    }

    private data class PlayDto(override val rawUri: String) : Playable

    private val raw = listOf(
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/17434811ea5a5363_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/17434811ea5a5363_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/17434811be4003bc_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/17434811d2b7a410_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/17434811f7659093_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/174348117d4df98e_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/17434811511b25b1_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/17434811964efedf_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/1749a48b963ff7bf_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/17434811cc839cc0_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/17434811eb9c02c6_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/174438879ae18e85_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1743481194610355_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/17434811c5e32584_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/174348113dbb8344_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1743481136176283_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/1749ed730aa00220_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/174348111116d8aa_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/17434811d8242464_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/1743481155154f77_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/17434811441414a3_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/17434811fa0bf772_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/17434811e56acd33_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/1743481133343093_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/1743481131531015_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/17434811c0fc9515_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/174575af3a269d55_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/17442323c84b67c8_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1747b06f3423b3a5_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/175545c301521bde_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/174575afa7c4c0c8_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/17434811ef3ded23_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/17434811b13c8a6c_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/1747b06f55adaeb5_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/174575af04909ec9_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/174575afa673af8c_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1748b9a2fd770f07_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/1747b06f1c6d1a4d_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1747b06f9cb057e1_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1747b06ffd44aaff_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1747b06f0453a9c7_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/1747b06fbaa4a685_아람720P?player",
        "https://edge11.midibus.kinxcdn.com/name/ch_173970ba/1747b06f22636a19_아람720P?player",
        "https://edge12.midibus.kinxcdn.com/name/ch_173970ba/1748b9a2f2f5731c_아람720P?player",
        "https://edge13.midibus.kinxcdn.com/name/ch_173970ba/1748b9a21eade6d5_아람720P?player"
    )

}