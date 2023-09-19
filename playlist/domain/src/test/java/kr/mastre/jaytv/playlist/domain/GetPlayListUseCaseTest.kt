package kr.mastre.jaytv.playlist.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.reactivex.rxjava3.core.Single

class GetPlayListUseCaseTest : FunSpec({

    test("Create Use Case") {
        val repository = FakePlaylistRepository()
        val useCase = GetPlayListUseCase(repository)

        useCase(GetPlayListUseCase.Params()).blockingGet() shouldBe listOf()
    }

})

class FakePlaylistRepository : PlaylistRepository {

    override fun getPlayList(): Single<List<Playable>> {
        return Single.just(listOf())
    }

}