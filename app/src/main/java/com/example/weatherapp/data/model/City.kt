package com.example.weatherapp.data.model;

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass;

@JsonClass(generateAdapter = true)
data class City (

        @Json(name="Key")
        val Key : String,
        @Json(name="EnglishName")
        val name : String,
        @Json(name="Country")
        val country : nameObj,
        @Json(name="AdministrativeArea")
        val adminArea : nameObj
)

@JsonClass(generateAdapter = true)
data class nameObj (

        @Json(name="EnglishName")
        val englishName : String
)