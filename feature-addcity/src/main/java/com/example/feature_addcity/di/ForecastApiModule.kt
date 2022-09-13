package com.example.feature_addcity.di

import com.example.data.api.ApiForecast
import com.example.data.api.ApiService
import com.example.data.mapper.ForecastMapper
import com.example.data.repoimpl.ForecastRepoImpl
import com.example.domain.repository.ForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ForecastApiModule {

    @Singleton
    @Provides
    fun provideForecastRepository(apiForecast: ApiForecast): ForecastRepository =
        ForecastRepoImpl(
            apiForecast, ForecastMapper()
        )

    @Singleton
    @Provides
    fun provideForecastApi(retrofit: Retrofit): ApiForecast = retrofit.create(
        ApiForecast::class.java
    )

}