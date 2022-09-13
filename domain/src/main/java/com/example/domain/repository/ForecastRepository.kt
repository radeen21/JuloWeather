package com.example.domain.repository

import com.example.domain.entities.forecast.ForecastEntities
import io.reactivex.Flowable

interface ForecastRepository {
    fun getCurrentWeatherByCityName(
        cityName: String,
        appId: String
    ): Flowable<ForecastEntities>
}