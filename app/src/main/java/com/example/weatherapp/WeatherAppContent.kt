package com.example.weatherapp

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.weatherapp.ui.screens.HomeScreen

@Composable
fun WeatherAppContent() {
    
    Scaffold(
        topBar = {

        }
    ) {
        HomeScreen()
    }
}
