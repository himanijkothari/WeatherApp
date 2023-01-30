package com.example.weatherapp.data.model;

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass;

@JsonClass(generateAdapter = true)
data class City (

        @Json(name="Version")
        val version : Int,
        @Json(name="Key")
        val Key : String,
        @Json(name="EnglishName")
        val name : String
)
