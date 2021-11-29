package com.example.weatherapplicaion.reposatory

import com.example.weatherapplicaion.Model.jsonFile.weather
import com.example.weatherapplicaion.api.RetrofitInstance
import retrofit2.http.Url

class Reposatory {
    suspend fun getData(city: String): weather {
        return RetrofitInstance.api.getData(city)
    }
}