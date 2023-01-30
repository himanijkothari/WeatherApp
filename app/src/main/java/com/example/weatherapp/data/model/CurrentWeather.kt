package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeather (

    @Json(name="WeatherText")
    val weatherText : String,
    @Json(name="Temperature")
    val temperature: Speed,
    @Json(name="RealFeelTemperature")
    val feelTemperature: Speed,
    @Json(name="RelativeHumidity")
    val humidity: Int,
    @Json(name="Wind")
    val wind: Wind,
    @Json(name="PrecipitationSummary")
    val precipitationSummary: PrecipitationSummary,
)

@JsonClass(generateAdapter = true)
data class PrecipitationSummary(

    @Json(name="Precipitation")
    val precipitation: Precipitation
)

@JsonClass(generateAdapter = true)
data class Precipitation(

    @Json(name="Metric")
    val metric : Metric
)

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name="Speed")
    val speed: Speed
)

@JsonClass(generateAdapter = true)
data class Speed(
    @Json(name="Metric")
    val metric : Metric
)


@JsonClass(generateAdapter = true)
data class Metric(

    @Json(name="Value")
    val value: Double,
    @Json(name="Unit")
    val unit: String
)