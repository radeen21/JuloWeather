package com.example.feature_home.di

import com.example.domain.PostExecutionThread
import com.example.domain.interactor.WeatherUseCase
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object WeatherUseCaseModule {

    @Provides
    @ViewModelScoped
    fun providePostRequestWeather(
        repository: WeatherRepository,
        postExecutionThread: PostExecutionThread
    ): WeatherUseCase {
        return WeatherUseCase(repository, postExecutionThread)
    }

}