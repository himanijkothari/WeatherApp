package com.example.weatherapp.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.model.DailyForecasts

@Composable
fun WeeklyForeCastCard( dailyforecast : DailyForecasts) {

    Card(
        modifier= Modifier
            .height(64.dp)
            .padding(start=8.dp),
        backgroundColor= Color.Transparent
    ){
        Row(
            modifier=Modifier
                .fillMaxWidth()
                .padding(start=16.dp,end=16.dp),
            verticalAlignment= Alignment.CenterVertically,
            horizontalArrangement= Arrangement.SpaceBetween
        ){
            Text(
                text=dailyforecast.date.substringBefore("T"),
                color=Color.LightGray,
                fontSize=12.sp,
                textAlign= TextAlign.Start,
                style= MaterialTheme.typography.body2
            )
            Text(
                text=dailyforecast.temperature.maximum.value.toString(),
                color=Color.LightGray,
                fontSize=12.sp,
                textAlign=TextAlign.Start,
                style=MaterialTheme.typography.body2
            )
            Text(
                text=dailyforecast.temperature.minimum.value.toString(),
                color=Color.LightGray,
                fontSize=12.sp,
                textAlign=TextAlign.Start,
                style=MaterialTheme.typography.body2
            )
            Text(
                text=dailyforecast.day.iconPhrase,
                color=Color.LightGray,
                fontSize=12.sp,
                textAlign=TextAlign.Start,
                style=MaterialTheme.typography.body2
            )
            Text(
                text=dailyforecast.night.iconPhrase,
                color=Color.LightGray,
                fontSize=12.sp,
                textAlign=TextAlign.Start,
                style=MaterialTheme.typography.body2
            )
         }
    }


}