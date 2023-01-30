package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.controller.ForecastController
import com.example.weatherapp.data.controller.TextController
import com.example.weatherapp.data.model.City
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.DayForecast
import com.example.weatherapp.data.model.HourlyForecast
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val textController: TextController,
    private val forecastController: ForecastController
) : ViewModel() {

    suspend fun getLocationKey(cityName : String) : List<City>? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO){
            val response = textController.getLocationKey(cityName)
            if(response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }

    suspend fun getCurrentWeather(locationKey: String) : List<CurrentWeather>? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO){
            val response = forecastController.getCurrentWeather(locationKey)
            if(response.isSuccessful){
                response.body()
            } else {
                null
            }
        }

    suspend fun getHourlyForecast(locationKey : String) : List<HourlyForecast>? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO){
            val response = forecastController.get12hourForecast(locationKey)
            if(response.isSuccessful){
                response.body()
            } else {
                null
            }
        }

    suspend fun getDaysForecast(locationKey: String) : DayForecast? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO){
            val response = forecastController.get5daysForecast(locationKey)
            if(response.isSuccessful){
                response.body()
            } else {
                null
            }
        }
}