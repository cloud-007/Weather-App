package com.example.weatherapplicaion.api

import com.example.weatherapplicaion.Model.jsonFile.weather
import retrofit2.http.GET
import retrofit2.http.Url

interface SimpleAPI {
    @GET("")
    suspend fun getData(@Url url: String): weather
}