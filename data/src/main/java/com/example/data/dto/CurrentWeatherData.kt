package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class CurrentWeatherData(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("wind_speed")
    val windSpeed: Float,
    @SerializedName("dt")
    var dt: Long?,
    @SerializedName("weather")
    val weather: List<Weather>
)