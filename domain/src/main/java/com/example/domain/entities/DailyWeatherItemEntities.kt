package com.example.domain.entities

class DailyWeatherItemEntities(
    val dt: Double,
    val temp: TempEntities,
    val weatherList: List<WeatherItemEntities>
)