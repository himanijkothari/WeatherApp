package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.data.model.City
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.HourlyForecast
import com.example.weatherapp.testForeCast
import com.example.weatherapp.ui.theme.Blue100
import com.example.weatherapp.ui.theme.Darktheme
import com.example.weatherapp.ui.widget.DailyForecastCard

@Composable
fun WeatherScreen(weatherViewModel: WeatherViewModel) {

    val forecastResult = produceState<List<HourlyForecast>?>(initialValue = null ){
        value = weatherViewModel.getHourlyForecast("310004")
    }

    val currentForecastResult = produceState<List<CurrentWeather>?>(initialValue = null ){
        value = weatherViewModel.getCurrentWeather("310004")
    }

    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Darktheme)
    ) {
       Column(
            modifier = Modifier
                .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row() {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.White
                    )

                    Text(
                        text = "31004",
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }

            Row() {
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {

                    currentForecastResult.value?.get(0)?.let {
                        Text(
                            text = "${it.temperature.metric.value}°",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h1

                        )
                        Text(
                            text = it.weatherText,
                            color = Color.Blue
                        )
                    }
                }
            }
        }

        Divider(
            color = Blue100,
            modifier = Modifier
                .height(1.dp)
        )

       Column(
            modifier = Modifier
                .padding(top = 32.dp, start = 32.dp, end = 16.dp, bottom = 32.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                 currentForecastResult.value?.get(0)?.let {
                    Column() {
                        Text(
                            text = "Wind:",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "${it.wind.speed.metric.value} ${it.wind.speed.metric.unit}",
                            color = Color.White,
                            style = MaterialTheme.typography.h5
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = "Feels like:",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "${it.feelTemperature.metric.value} ${it.feelTemperature.metric.unit}",
                            color = Color.White,
                            style = MaterialTheme.typography.h5
                        )
                    }

                    Spacer(modifier = Modifier.width(80.dp))

                    Column() {
                        Text(
                            text = "Precipitation",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "${it.precipitationSummary.precipitation.metric.value} ${it.precipitationSummary.precipitation.metric.unit}",
                            color = Color.White,
                            style = MaterialTheme.typography.h5
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = "Humidity:",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "${it.humidity} %",
                            color = Color.White,
                            style = MaterialTheme.typography.h5
                        )
                    }
                    }
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            forecastResult.value?.let {
                items(it) { forecast ->
                    DailyForecastCard(forecast)
                }
            }
        }
    }

}
