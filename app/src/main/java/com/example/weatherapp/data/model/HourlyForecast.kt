package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyForecast (

    @Json(name="DateTime")
    val datetime : String,
    @Json(name="WeatherIcon")
    val weatherIcon : Int,
    @Json(name="IconPhrase")
    val iconphrase : String,
    @Json(name="Temperature")
    val temperature : Temperature
)

@JsonClass(generateAdapter = true)
data class Temperature (

    @Json(name="Value")
    val value : Double,
    @Json(name="Unit")
    val unit : String
)


