package com.example.data.repoimpl

import com.example.data.api.ApiForecast
import com.example.data.mapper.ForecastMapper
import com.example.domain.entities.forecast.ForecastEntities
import com.example.domain.repository.ForecastRepository
import io.reactivex.Flowable
import javax.inject.Inject

class ForecastRepoImpl @Inject constructor(
    private val api: ApiForecast,
    private val forecastMapper: ForecastMapper
) : ForecastRepository {

    override fun getCurrentWeatherByCityName(cityName: String, appId: String): Flowable<ForecastEntities> =
        api.getCurrentWeatherByCityName(cityName, appId).map(forecastMapper)
}