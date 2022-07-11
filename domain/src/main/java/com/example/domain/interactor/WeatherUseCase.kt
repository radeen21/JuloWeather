package com.example.domain.interactor

import com.example.domain.FlowableUseCase
import com.example.domain.PostExecutionThread
import com.example.domain.entities.WeatherEntities
import com.example.domain.repository.WeatherRepository
import io.reactivex.Flowable

class WeatherUseCase constructor(
    private val repository: WeatherRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<WeatherEntities, WeatherUseCase.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<WeatherEntities> =
        repository.getToken(params.lat, params.lon, params.exclude, params.apiKey)

    data class Params(val lat: String, val lon: String, val exclude: String, val apiKey: String)
}