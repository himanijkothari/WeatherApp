package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.data.model.DayForecast
import com.example.weatherapp.ui.theme.Darktheme
import com.example.weatherapp.ui.widget.WeeklyForeCastCard

@Composable
fun ForecastScreen(locationKey : String,weatherViewModel: WeatherViewModel) {

    val weeklyForecastResult = produceState<DayForecast?>(initialValue = null ){
        value = weatherViewModel.getDaysForecast(locationKey)
    }

    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Darktheme)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end= 16.dp,top = 8.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(id = R.string.label_date),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = stringResource(id = R.string.label_H),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = stringResource(id = R.string.label_L),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = stringResource(id = R.string.label_day),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = stringResource(id = R.string.label_night),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.White,
            thickness = 2.dp
        )

        LazyColumn(){
            weeklyForecastResult.value?.let { it ->
                items(it.dailyforecast){ it1 ->
                    WeeklyForeCastCard(it1)
                }
            }
        }
    }
}