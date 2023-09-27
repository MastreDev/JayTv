package kr.mastre.playlist

import io.reactivex.rxjava3.core.Single

internal interface SingleUseCase<Params, T : Any> {
    operator fun invoke(params: Params): Single<T>

}