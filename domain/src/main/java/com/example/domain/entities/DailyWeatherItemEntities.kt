package com.example.domain.entities

class DailyWeatherItemEntities(
    val dt: Long,
    val temp: TempEntities,
    val weatherList: List<WeatherItemEntities>
)