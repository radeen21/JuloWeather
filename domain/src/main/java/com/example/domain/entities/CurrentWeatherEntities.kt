package com.example.domain.entities

class CurrentWeatherEntities(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Float,
    val weather: List<WeatherDatEntities>
)