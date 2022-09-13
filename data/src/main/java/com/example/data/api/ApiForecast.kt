package com.example.data.api

import com.example.data.dto.forecast.ForecastDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiForecast {

    @GET("/data/2.5/weather")
    fun getCurrentWeatherByCityName(
        @Query("q") cityName: String,
        @Query("appid") apikey: String
    ): Flowable<ForecastDto>
}