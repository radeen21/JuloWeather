package com.example.data.api

import com.example.data.dto.WeatherDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/onecall")
    fun getWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String,
        @Query("appid") apikey: String
    ): Flowable<WeatherDto>

}

