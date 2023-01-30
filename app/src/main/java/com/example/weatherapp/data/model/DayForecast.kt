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
    val day: IconObject,
    @Json(name="Night")
    val night: IconObject
)

@JsonClass(generateAdapter = true)
data class DailyTemperature (

    @Json(name="Minimum")
    val minimum: Temperature,
    @Json(name="Maximum")
    val maximum: Temperature
)

@JsonClass(generateAdapter = true)
data class IconObject(
    @Json(name="Icon")
    val icon: Int,
    @Json(name="IconPhrase")
    val iconPhrase: String
)
