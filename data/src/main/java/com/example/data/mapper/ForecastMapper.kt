package com.example.data.mapper

import com.example.data.dto.forecast.ForecastDto
import com.example.domain.entities.WeatherDatEntities
import com.example.domain.entities.forecast.ForecastEntities

class ForecastMapper : Mapper<ForecastDto, ForecastEntities>() {
    override fun apply(from: ForecastDto): ForecastEntities {
        return ForecastEntities(
            ForecastEntities.Coord(
                from.coord.lon,
                from.coord.lat
            ),
            from.weather.map { weather ->
                WeatherDatEntities(
                    weather.id,
                    weather.main,
                    weather.description,
                    weather.icon
                )
            },
            from.base,
            ForecastEntities.Main(
                from.main.temp,
                from.main.feels_like,
                from.main.temp_min,
                from.main.temp_max,
                from.main.pressure,
                from.main.humidity,
                from.main.sea_level,
                from.main.grnd_level
            ),
            from.visibility,
            ForecastEntities.Wind(
                from.wind.speed,
                from.wind.deg,
                from.wind.gust,
            ),
            ForecastEntities.Cloud(
                from.clouds.type
            ),
            from.dt,
            ForecastEntities.Sys(
                from.sys?.all,
                from.sys?.id,
                from.sys?.country,
                from.sys?.sunrise,
                from.sys?.sunset
            ),
            from.timezone,
            from.id,
            from.name,
            from.cod
        )
    }
}