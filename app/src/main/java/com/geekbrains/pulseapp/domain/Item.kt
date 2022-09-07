package com.geekbrains.pulseapp.domain

import com.google.gson.annotations.SerializedName

data class Item(
    val id: Int,
    val date: String,
    val time: String,
    @SerializedName("pressure_1")
    val firstPressure: Int,
    @SerializedName("pressure_2")
    val secondPressure: Int,
    val pulse: Int
)