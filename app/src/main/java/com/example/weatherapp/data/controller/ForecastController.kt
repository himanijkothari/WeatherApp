package com.example.weatherapp.data.controller


import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.DayForecast
import com.example.weatherapp.data.model.HourlyForecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ForecastController {

    @GET("currentconditions/v1/{locationKey}")
    suspend fun getCurrentWeather(@Path("locationKey") locationKey: String,@Query("details") details: String = "true") : Response<List<CurrentWeather>>

    @GET("forecasts/v1/hourly/12hour/{locationKey}")
    suspend fun get12hourForecast(@Path("locationKey") locationKey: String,@Query("details") details: String = "true", @Query("metric") metric: String = "true") : Response<List<HourlyForecast>>

    @GET("forecasts/v1/daily/5day/{locationKey}")
    suspend fun get5daysForecast(@Path("locationKey") locationKey: String, @Query("metric") metric: String = "true") : Response<DayForecast>

}