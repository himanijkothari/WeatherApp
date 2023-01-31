package com.example.weatherapp

import androidx.annotation.StringRes
import androidx.navigation.NamedNavArgument



sealed class Screens(
    val route:String,
    val arguments:List<NamedNavArgument> = emptyList(),
    @StringRes val resourceId: Int
)

object Weather: Screens(
    route = "Weather/{locationKey}",
    resourceId = R.string.screen_weather
)

object Forecast: Screens(
    route = "Forecast/{locationKey}",
    resourceId = R.string.screen_forecast
)

object Menu: Screens(
    route = "Menu",
    resourceId = R.string.screen_menu
)