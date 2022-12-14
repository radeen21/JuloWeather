package com.example.domain.repository

import com.example.domain.entities.WeatherEntities
import com.example.domain.entities.forecast.ForecastEntities
import io.reactivex.Flowable

interface WeatherRepository {
    fun getToken(
        lat: String,
        lon: String,
        exclude: String,
        appid: String
    ): Flowable<WeatherEntities>
}