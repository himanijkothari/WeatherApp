package com.example.weatherapp

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NamedNavArgument



sealed class Screens(
    val route:String,
    val arguments:List<NamedNavArgument> = emptyList(),
    @StringRes val resourceId: Int
)

object Weather: Screens(
    route = "Weather",
    resourceId = R.string.screen_weather
)

object Forecast: Screens(
    route = "Forecast",
    resourceId = R.string.screen_forecast
)

object Menu: Screens(
    route = "Menu",
    resourceId = R.string.screen_menu
)