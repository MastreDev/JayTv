package kr.mastre.playlist.data

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldNotHaveSize

class PlaylistRepositoryImplTest : FunSpec({

    test("repository should return list not empty") {
        val fbSource = FirebaseRemoteSource(Firebase.remoteConfig)
        val repository = PlaylistRepositoryImpl(remoteSource = fbSource)
        repository.getPlayList().blockingGet() shouldNotHaveSize 0
    }

})
