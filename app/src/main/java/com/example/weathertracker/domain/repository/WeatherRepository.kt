package com.example.weathertracker.domain.repository


import com.example.weathertracker.common.Result
import com.example.weathertracker.domain.model.WeatherResponseModel
import kotlinx.coroutines.flow.Flow


interface WeatherRepository {

    suspend fun getWeatherByName(apiKey: String, name: String): Flow<Result<WeatherResponseModel>>
}