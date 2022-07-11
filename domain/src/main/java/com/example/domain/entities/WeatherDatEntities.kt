package com.example.domain.entities

import com.google.gson.annotations.SerializedName

class WeatherDatEntities(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)