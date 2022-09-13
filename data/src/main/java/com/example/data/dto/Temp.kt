package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("min")
    val min: Double,
    @SerializedName("max")
    var max: Double,
)