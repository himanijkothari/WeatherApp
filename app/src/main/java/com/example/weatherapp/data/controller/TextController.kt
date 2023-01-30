package com.example.weatherapp.data.controller

import com.example.weatherapp.data.model.City
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TextController {

    @GET("locations/v1/cities/search")
    suspend fun getLocationKey(@Query("q") q : String ) : Response<List<City>>

    @GET("locations/v1/search")
    suspend fun getSearchedLocation(@Query("q") q: String) : Response<List<City>>

}