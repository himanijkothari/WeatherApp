package com.example.weatherapp.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.IconMapping
import com.example.weatherapp.data.model.HourlyForecast

@Composable
fun DailyForecastCard(forecast:HourlyForecast){

    val date = forecast.datetime.substringAfter("T").substring(0,5)
    val icon = IconMapping(forecast.weatherIcon)

    Card(
        shape = RoundedCornerShape(32.dp),
        backgroundColor = Color.DarkGray
    ){
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = date,
                color = Color.LightGray
            )
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = forecast.temperature.value.toString()+"°",
                color = Color.LightGray
            )

        }
    }
}
