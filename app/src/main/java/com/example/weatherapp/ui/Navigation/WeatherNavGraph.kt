package com.example.weatherapp.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
                arguments = listOf(
                    navArgument("locationKey") { type = NavType.StringType },
                    navArgument("cityName") { type = NavType.StringType },
                )
            ){
                val locationKey = it.arguments?.getString("locationKey")
                val name = it.arguments?.getString("cityName")
                locationKey?.let {
                    if (name != null) {
                        WeatherScreen(
                            locationKey,
                            name,
                            weatherViewModel,
                            navController
                        )
                    }
                }
            }

            composable(
                Forecast.route,
                arguments = Forecast.arguments
            ){
                val locationKey = it.arguments?.getString("locationKey")
                locationKey?.let{
                    ForecastScreen(
                        locationKey,
                        weatherViewModel)
                }

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