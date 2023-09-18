package kr.mastre.playlist.data

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.rx3.rxSingle
import kotlinx.coroutines.tasks.await
import kotlinx.serialization.json.Json
import kr.mastre.jaytv.playlist.domain.Playable

internal class FirebaseRemoteSource(
    private val remoteConfig: FirebaseRemoteConfig,
) {
    init {
        val configSetting = remoteConfigSettings {
            minimumFetchIntervalInSeconds = if(BuildConfig.DEBUG) 3600 else 36000
        }
        remoteConfig.setConfigSettingsAsync(configSetting)
    }

    fun fetchPlayList(): Single<List<Playable>> {
        return rxSingle {
            remoteConfig.fetchAndActivate().await()
            val configs = remoteConfig["arami_playlist"].asString().let { Json.decodeFromString<GetPlayListResponse>(it) }
            configs.playlist
        }
    }

}