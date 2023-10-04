package kr.mastre.jaytv.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.mastre.jaytv.impl.FirebaseRemoteDataSource
import kr.mastre.playlist.data.PlaylistRemoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {
    @Binds
    @Singleton
    abstract fun providePlayListRemoteDataSource(impl: FirebaseRemoteDataSource): PlaylistRemoteDataSource

}