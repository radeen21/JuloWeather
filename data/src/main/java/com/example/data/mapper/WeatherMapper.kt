package com.example.data.mapper

import com.example.data.dto.WeatherDto
import com.example.domain.entities.*

class WeatherMapper : Mapper<WeatherDto, WeatherEntities>() {
    override fun apply(from: WeatherDto): WeatherEntities {
        return WeatherEntities(
            from.lat, from.lon, from.timezone, CurrentWeatherEntities(
                from.current.temp,
                from.current.pressure,
                from.current.humidity,
                from.current.windSpeed,
                from.current.weather.map { weather ->
                    WeatherDatEntities(
                        weather.id, weather.main, weather.description, weather.icon
                    )
                }
            ),
            from.daily.map { daily ->
                DailyWeatherItemEntities(
                    daily.dt,
                    TempEntities(daily.temp.min),
                    daily.weatherList.map { item ->
                        WeatherItemEntities(
                            item.id,
                            item.mainDesc,
                            item.detailDesc,
                            item.iconCode
                        )
                    }
                )
            })
    }
}