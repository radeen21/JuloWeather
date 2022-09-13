package com.example.feature_home.di

import com.example.data.api.ApiService
import com.example.data.mapper.ForecastMapper
import com.example.data.mapper.WeatherMapper
import com.example.data.repoimpl.WeatherRepoImpl
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherApiModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(apiService: ApiService): WeatherRepository =
        WeatherRepoImpl(
            apiService, WeatherMapper()
        )

    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java
    )

}