package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("lat")
    val lat: Float = 0f,
    @SerializedName("lon")
    val lon: Float = 0f,
    @SerializedName("timezone")
    val timezone: String = "",
    @SerializedName("current")
    val current: CurrentWeatherData,
    @SerializedName("daily")
    val daily: List<DailyWeatherItemData>
)

