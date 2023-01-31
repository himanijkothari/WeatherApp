package com.example.weatherapp.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.Forecast
import com.example.weatherapp.Menu
import com.example.weatherapp.Weather
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.ui.screens.ForecastScreen
import com.example.weatherapp.ui.screens.MenuScreen
import com.example.weatherapp.ui.screens.WeatherScreen

@Composable
fun WeatherNavGraph(navController: NavHostController, weatherViewModel: WeatherViewModel) {
    
        NavHost(
            navController = navController,
            startDestination = Menu.route
        ){
            composable(
                Weather.route,
                arguments = Weather.arguments
            ){
                val locationKey = it.arguments?.getString("locationKey")
                locationKey?.let {
                    WeatherScreen(
                        locationKey,
                        weatherViewModel
                    )
                }
            }

            composable(
                Forecast.route,
                arguments = Forecast.arguments
            ){
                ForecastScreen(weatherViewModel)
            }

            composable(
                Menu.route,
                arguments = Weather.arguments
            ){
                MenuScreen(
                    navController,
                    weatherViewModel)
            }
        }
}