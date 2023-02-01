package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.IconMapping
import com.example.weatherapp.R
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.HourlyForecast
import com.example.weatherapp.ui.theme.Darktheme
import com.example.weatherapp.ui.theme.softBlack
import com.example.weatherapp.ui.widget.DailyForecastCard

@Composable
fun WeatherScreen(
    locationKey: String,
    name: String,
    weatherViewModel: WeatherViewModel,
    navController: NavController
) {
    val forecastResult = produceState<List<HourlyForecast>?>(initialValue = null) {
        value = weatherViewModel.getHourlyForecast(locationKey)
    }

    val currentForecastResult = produceState<List<CurrentWeather>?>(initialValue = null) {
        value = weatherViewModel.getCurrentWeather(locationKey)
    }

    val currentWeatherIcon = currentForecastResult.value?.get(0)
        ?.let { IconMapping(it.weatherIcon) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Darktheme)
    ) {
        Column(
            modifier = Modifier
                //.padding( start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp,end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row() {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color.White
                    )

                    Text(
                        text = name,
                        color = Color.LightGray,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                currentWeatherIcon?.let { painterResource(id = it) }?.let {
                    Icon(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp),
                        tint = Color.Unspecified
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
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
                            modifier = Modifier.padding(start = 48.dp),
                            fontSize = 18.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }

            LazyColumn(
                modifier = Modifier.fillMaxHeight(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                item {
                    Column(
                        modifier = Modifier
                            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            currentForecastResult.value?.get(0)?.let {
                                Column() {
                                    Card(
                                        modifier = Modifier.size(140.dp, 80.dp),
                                        shape = RoundedCornerShape(16.dp),
                                        backgroundColor = softBlack
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = stringResource(id = R.string.label_wind),
                                                color = Color.LightGray,
                                                style = MaterialTheme.typography.subtitle2
                                            )
                                            Text(
                                                text = "${it.wind.speed.metric.value}${it.wind.speed.metric.unit}",
                                                color = Color.White,
                                                style = MaterialTheme.typography.h5
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(16.dp))

                                    Card(
                                        modifier = Modifier.size(140.dp, 80.dp),
                                        shape = RoundedCornerShape(16.dp),
                                        backgroundColor = softBlack
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = stringResource(id = R.string.label_feels_like),
                                                color = Color.LightGray,
                                                style = MaterialTheme.typography.subtitle2
                                            )
                                            Text(
                                                text = "${it.feelTemperature.metric.value}${it.feelTemperature.metric.unit}",
                                                color = Color.White,
                                                style = MaterialTheme.typography.h5
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(40.dp))

                                Column() {
                                    Card(
                                        modifier = Modifier.size(140.dp, 80.dp),
                                        shape = RoundedCornerShape(16.dp),
                                        backgroundColor = softBlack
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = stringResource(id = R.string.label_precipitation),
                                                color = Color.LightGray,
                                                style = MaterialTheme.typography.subtitle2
                                            )
                                            Text(
                                                text = "${it.precipitationSummary.precipitation.metric.value}${it.precipitationSummary.precipitation.metric.unit}",
                                                color = Color.White,
                                                style = MaterialTheme.typography.h5
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Card(
                                        modifier = Modifier.size(140.dp, 80.dp),
                                        shape = RoundedCornerShape(16.dp),
                                        backgroundColor = softBlack
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = stringResource(id = R.string.label_humidity),
                                                color = Color.LightGray,
                                                style = MaterialTheme.typography.subtitle2
                                            )
                                            Text(
                                                text = "${it.humidity}%",
                                                color = Color.White,
                                                style = MaterialTheme.typography.h5
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                item {
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

                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = stringResource(id = R.string.label_forecast_screen),
                            modifier = Modifier
                                .clickable { navController.navigate("Forecast/${locationKey}") },
                            color = Color.White,
                            style = TextStyle(textDecoration = TextDecoration.Underline)
                        )
                    }
                }
            }
        }
    }

