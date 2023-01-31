package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.data.model.DayForecast
import com.example.weatherapp.ui.theme.Darktheme
import com.example.weatherapp.ui.widget.WeeklyForeCastCard

@Composable
fun ForecastScreen(locationKey : String,weatherViewModel: WeatherViewModel) {

    val weeklyForecastResult = produceState<DayForecast?>(initialValue = null ){
        value = weatherViewModel.getDaysForecast(locationKey)
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
    }
}