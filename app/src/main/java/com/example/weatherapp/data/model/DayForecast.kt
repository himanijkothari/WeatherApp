package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DayForecast (

    @Json(name="DailyForecasts")
    val dailyforecast : DailyForecasts
)

@JsonClass(generateAdapter = true)
data class DailyForecasts(

    @Json(name="Date")
    val date : String,
    @Json(name="Temperature")
    val temperature: DailyTemperature
)

@JsonClass(generateAdapter = true)
data class DailyTemperature (

    @Json(name="Minimum")
    val minimum: Temperature,
    @Json(name="Maximum")
    val maximum: Temperature
)