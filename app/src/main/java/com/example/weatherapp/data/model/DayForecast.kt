package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DayForecast (

    @Json(name="DailyForecasts")
    val dailyforecast : List<DailyForecasts>
)

@JsonClass(generateAdapter = true)
data class DailyForecasts(

    @Json(name="Date")
    val date : String,
    @Json(name="Temperature")
    val temperature: DailyTemperature,
    @Json(name="Day")
    val day: Day,
    @Json(name="Night")
    val night: Night
)

@JsonClass(generateAdapter = true)
data class DailyTemperature (

    @Json(name="Minimum")
    val minimum: Temperature,
    @Json(name="Maximum")
    val maximum: Temperature
)

@JsonClass(generateAdapter = true)
data class Day(
    @Json(name="Icon")
    val icon: Int,
    @Json(name="IconPhrase")
    val iconPhrase: String
)

@JsonClass(generateAdapter = true)
data class Night(
    @Json(name="Icon")
    val icon: Int,
    @Json(name="IconPhrase")
    val iconPhrase: String
)