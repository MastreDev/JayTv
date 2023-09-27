package kr.mastre.playlist.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.mastre.playlist.PlaylistRepository
import kr.mastre.playlist.data.PlaylistRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Singleton
    @Provides
    fun providePlaylistRepository(impl: PlaylistRepositoryImpl): PlaylistRepository = impl

}