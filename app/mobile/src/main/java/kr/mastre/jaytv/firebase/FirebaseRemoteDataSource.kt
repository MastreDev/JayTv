package kr.mastre.jaytv.firebase

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.rx3.rxSingle
import kotlinx.coroutines.tasks.await
import kotlinx.serialization.json.Json
import kr.mastre.playlist.data.BuildConfig
import kr.mastre.playlist.data.PlayableDto
import kr.mastre.playlist.data.PlaylistRemoteDataSource
import javax.inject.Inject

internal class FirebaseRemoteDataSource @Inject constructor(
    private val remoteConfig: FirebaseRemoteConfig,
) : PlaylistRemoteDataSource {

    init {
        val configSetting = remoteConfigSettings {
            minimumFetchIntervalInSeconds = if (BuildConfig.DEBUG) 3600 else 36000
        }
        remoteConfig.setConfigSettingsAsync(configSetting)
    }

    override fun fetchPlayList(): Single<List<PlayableDto>> {
        return rxSingle {
            remoteConfig.fetchAndActivate().await()
            val configs = remoteConfig["arami_playlist"].asString().let { Json.decodeFromString<GetPlayListResponse>(it) }
            configs.playlist
        }
    }

}