package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class DailyWeatherItemData(
    @SerializedName("dt")
    val dt : Long,
    @SerializedName("temp")
    val temp : Temp,
    @SerializedName("weather")
    val weatherList : List<WeatherItemData>
)
