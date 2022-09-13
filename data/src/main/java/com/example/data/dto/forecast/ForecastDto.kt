package com.example.data.dto.forecast

import com.example.data.dto.Weather
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("coord")
    var coord: Coord,
    @SerializedName("weather")
    var weather: List<Weather>,
    @SerializedName("base")
    var base: String,
    @SerializedName("main")
    var main: Main,
    @SerializedName("visibility")
    var visibility: Int?,
    @SerializedName("wind")
    var wind: Wind,
    @SerializedName("clouds")
    var clouds: Cloud,
    @SerializedName("dt")
    var dt: Long?,
    @SerializedName("sys")
    var sys: Sys?,
    @SerializedName("timezone")
    var timezone: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("cod")
    var cod: Int?
) {
    data class Coord(
        @SerializedName("lon")
        var lon: Double?,
        @SerializedName("lat")
        var lat: Double?
    )

    data class Main(
        @SerializedName("temp")
        var temp: Double?,
        @SerializedName("feels_like")
        var feels_like: Double?,
        @SerializedName("temp_min")
        var temp_min: Double?,
        @SerializedName("temp_max")
        var temp_max: Double?,
        @SerializedName("pressure")
        var pressure: Double?,
        @SerializedName("humidity")
        var humidity: Double?,
        @SerializedName("sea_level")
        var sea_level: Double?,
        @SerializedName("grnd_level")
        var grnd_level: Double?,
    )

    data class Wind(
        @SerializedName("speed")
        var speed: Double?,
        @SerializedName("deg")
        var deg: Int?,
        @SerializedName("gust")
        var gust: Double?,
    )

    data class Cloud(
        @SerializedName("type")
        var type: Int?
    )

    data class Sys(
        @SerializedName("all")
        var all: Int?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("country")
        var country: String?,
        @SerializedName("sunrise")
        var sunrise: Int?,
        @SerializedName("sunset")
        var sunset: Int?
    )
}