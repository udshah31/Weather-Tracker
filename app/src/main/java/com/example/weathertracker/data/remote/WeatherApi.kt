package com.example.weathertracker.data.remote

import com.example.weathertracker.data.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/current.json")
    suspend fun getWeatherByName(
        @Query("key") apiKey: String,
        @Query("q") query:String
    ): WeatherDto
}