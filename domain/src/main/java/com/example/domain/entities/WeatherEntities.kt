package com.example.domain.entities

class WeatherEntities(
    val lat: Float = 0f,
    val lon: Float = 0f,
    val timezone: String = "",
    val current: CurrentWeatherEntities,
    val daily: List<DailyWeatherItemEntities>
)