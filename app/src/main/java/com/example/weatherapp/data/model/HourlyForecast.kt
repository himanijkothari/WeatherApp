package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyForecast (

    @Json(name="DateTime")
    val datetime : String,
    @Json(name="IconPhrase")
    val iconphrase : String,
    @Json(name="Temperature")
    val temperature : Temperature,
    @Json(name="Wind")
    val wind : Wind,
    @Json(name="RelativeHumidity")
    val humidity : String,
    @Json(name="PrecipitationProbability")
    val precipitation : String,
    @Json(name="RainProbability")
    val chanceOfRain : String,
)

@JsonClass(generateAdapter = true)
data class Temperature (

    @Json(name="Value")
    val value : String,
    @Json(name="Unit")
    val unit : String
)


@JsonClass(generateAdapter = true)
data class Wind(

    @Json(name="Speed")
    val speed: Speed
)


@JsonClass(generateAdapter = true)
data class Speed(

    @Json(name="Value")
    val value: String,
    @Json(name="Unit")
    val unit : String
)


