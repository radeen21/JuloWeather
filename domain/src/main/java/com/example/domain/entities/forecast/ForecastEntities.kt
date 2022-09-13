package com.example.domain.entities.forecast

import com.example.domain.entities.WeatherDatEntities

data class ForecastEntities(
    var coord: Coord,
    var weather: List<WeatherDatEntities>,
    var base: String,
    var main: Main,
    var visibility: Int?,
    var wind: Wind,
    var clouds: Cloud,
    var dt: Long?,
    var sys: Sys?,
    var timezone: String?,
    var id: Int?,
    var name: String?,
    var cod: Int?

) {

    data class Coord(
        var lon: Double?,
        var lat: Double?
    )

    data class Main(
        var temp: Double?,
        var feels_like: Double?,
        var temp_min: Double?,
        var temp_max: Double?,
        var pressure: Double?,
        var humidity: Double?,
        var sea_level: Double?,
        var grnd_level: Double?,
    )

    data class Wind(
        var speed: Double?,
        var deg: Int?,
        var gust: Double?,
    )

    data class Cloud(
        var type: Int?
    )

    data class Sys(
        var all: Int?,
        var id: Int?,
        var country: String?,
        var sunrise: Int?,
        var sunset: Int?
    )
}