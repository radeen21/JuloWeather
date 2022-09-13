package com.example.domain.entities.forecast

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ForecastDataEntities(
    @PrimaryKey var id: Int,
    var lat: Double?,
    var lon: Double,
    var name: String?
)