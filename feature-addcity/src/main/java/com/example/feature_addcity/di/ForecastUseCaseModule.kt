package com.example.feature_addcity.di

import com.example.domain.PostExecutionThread
import com.example.domain.interactor.ForecastUseCase
import com.example.domain.repository.ForecastRepository
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ForecastUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetRequestForecast(
        repository: ForecastRepository,
        postExecutionThread: PostExecutionThread
    ): ForecastUseCase {
        return ForecastUseCase(repository, postExecutionThread)
    }

}