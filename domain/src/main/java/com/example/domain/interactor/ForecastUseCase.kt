package com.example.domain.interactor

import com.example.domain.FlowableUseCase
import com.example.domain.PostExecutionThread
import com.example.domain.entities.forecast.ForecastEntities
import com.example.domain.repository.ForecastRepository
import com.example.domain.repository.WeatherRepository
import io.reactivex.Flowable

class ForecastUseCase constructor(
    private val repository: ForecastRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<ForecastEntities, ForecastUseCase.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<ForecastEntities> =
        repository.getCurrentWeatherByCityName(params.cityName, params.appId)

    data class Params(val cityName: String, val appId: String)
}