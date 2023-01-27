package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherapp.ui.theme.Darktheme
import com.example.weatherapp.ui.widget.WeeklyForeCastCard

@Composable
fun ForecastScreen() {

    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Darktheme)
    ){
        WeeklyForeCastCard()
    }
}