package com.example.weatherapp.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.IconMapping
import com.example.weatherapp.data.model.DailyForecasts
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun WeeklyForeCastCard( dailyforecast : DailyForecasts) {

    val dayIcon = IconMapping(dailyforecast.day.icon)
    val nightIcon = IconMapping(dailyforecast.night.icon)

    val localDate = LocalDate.parse(dailyforecast.date.substringBefore("T"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    Card(
        modifier= Modifier
            .height(64.dp),
           // .padding(start=8.dp),
        backgroundColor= Color.Transparent
    ){
        Row(
            modifier=Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment= Alignment.CenterVertically,
            horizontalArrangement= Arrangement.SpaceBetween
        ){
            Text(
                text = localDate.dayOfWeek.toString(),
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
            Icon(
                painter = painterResource(id = dayIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Icon(
                painter = painterResource(id = nightIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )
         }
    }


}