package kr.mastre.jaytv.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kr.mastre.feature.home.ListViewModel

@EntryPoint
@InstallIn(ActivityComponent::class)
interface AssistedViewModelFactoryProvider {

    fun listViewModelFactory() : ListViewModel.Factory

}