package com.example.weatherapp.data.controller

import com.example.weatherapp.data.model.DailyForecasts
import com.example.weatherapp.data.model.HourlyForecast
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ForecastController {

    @GET("forecasts/v1/hourly/12hour/{locationKey}")
    suspend fun get12hourForecast(@Path("locationKey") locationKey: String, @Query("metric") metric: String = "true") : List<HourlyForecast>

    @GET("http://dataservice.accuweather.com/forecasts/v1/daily/5day/{locationKey}")
    suspend fun get5daysForecast(@Path("locationKey") locationKey: String, @Query("metric") metric: String = "true") : List<DailyForecasts>

}