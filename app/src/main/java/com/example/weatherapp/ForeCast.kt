package com.example.weatherapp

data class ForecastTemp(
val time : String,
val temperature : String
)


val testForeCast = listOf(
    ForecastTemp(
    time="7:00",
    temperature="4"
    ),
    ForecastTemp(
    time="8:00",
    temperature="5"
    ),
    ForecastTemp(
    time="9:00",
    temperature="6"
    ),
    ForecastTemp(
    time="10:00",
    temperature="7"
    ),
    ForecastTemp(
    time="11:00",
    temperature="8"
    )
)
