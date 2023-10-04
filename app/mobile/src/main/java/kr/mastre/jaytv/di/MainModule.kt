package kr.mastre.jaytv.di

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object MainModule {
    @Provides
    fun provideFirebaseRemoteConfig() : FirebaseRemoteConfig {
        return FirebaseRemoteConfig.getInstance()
    }

}