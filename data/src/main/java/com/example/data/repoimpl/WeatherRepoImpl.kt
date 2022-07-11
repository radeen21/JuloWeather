package com.example.data.repoimpl

import com.example.data.api.ApiService
import com.example.data.mapper.WeatherMapper
import com.example.domain.entities.WeatherEntities
import com.example.domain.repository.WeatherRepository
import io.reactivex.Flowable
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val api: ApiService,
    private val weatherMapper: WeatherMapper,
) : WeatherRepository {

    override fun getToken(
        lat: String,
        lon: String,
        exclude: String,
        appid: String
    ): Flowable<WeatherEntities> =
        api.getWeatherData(lat, lon, exclude, appid).map(weatherMapper)
}