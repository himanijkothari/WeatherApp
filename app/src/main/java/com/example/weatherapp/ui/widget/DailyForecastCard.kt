package com.example.weatherapp.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ForecastTemp

@Composable
fun DailyForecastCard(forecast:ForecastTemp){

    Card(
        shape=RoundedCornerShape(16.dp),
        backgroundColor=Color.DarkGray
    ){
        Column(
            modifier=Modifier.padding(16.dp),
            verticalArrangement=Arrangement.Center
        ){
            Text(
                text=forecast.time,
                color=Color.LightGray
            )
            Text(
                text=forecast.temperature,
                color=Color.LightGray
            )
            Icon(
                Icons.Rounded.Add,
                contentDescription=null,
                tint=Color.LightGray
            )
        }
    }
}
