package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.controller.TextController
import com.example.weatherapp.data.model.City
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val textController: TextController
) : ViewModel() {

    suspend fun getLocationKey() : List<City>? =
        withContext(viewModelScope.coroutineContext + Dispatchers.IO){
            val response = textController.getLocationKey("stockholm")
            if(response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
}