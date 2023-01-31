package com.example.weatherapp.ui.screens

import androidx.compose.runtime.Composable
import com.example.weatherapp.WeatherViewModel

@Composable
fun ForecastScreen(weatherViewModel: WeatherViewModel) {

   /* val weeklyForecastResult = produceState<DayForecast?>(initialValue = null ){
        value = weatherViewModel.getDaysForecast("310004")
    }

    LazyColumn(
        modifier= Modifier
            .fillMaxSize()
            .background(Darktheme)
    ){
        weeklyForecastResult.value?.let { it ->
            items(it.dailyforecast){ it1 ->
                WeeklyForeCastCard(it1)
            }
        }
    }*/
}