package kr.mastre.playlist.data

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldNotHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class PlaylistRepositoryImplTest : FunSpec({

    test("repository should return list not empty") {
        val repository = PlaylistRepositoryImpl()
        repository.getPlayList().blockingGet() shouldNotHaveSize 0
    }

})
