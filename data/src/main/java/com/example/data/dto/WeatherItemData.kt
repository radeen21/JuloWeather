package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherItemData (
    @SerializedName("id")
    val id : Int,
    @SerializedName("main")
    val mainDesc : String,
    @SerializedName("description")
    val detailDesc : String,
    @SerializedName("icon")
    val iconCode : String
)