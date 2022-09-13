package com.example.domain.entities

import com.google.gson.annotations.SerializedName

class CurrentWeatherEntities(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Float,
    var dt: Long?,
    val weather: List<WeatherDatEntities>
)