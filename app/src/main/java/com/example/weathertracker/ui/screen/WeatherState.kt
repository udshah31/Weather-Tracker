package com.example.weathertracker.ui.screen

import com.example.weathertracker.domain.model.WeatherResponseModel

data class WeatherState(
    val isLoading : Boolean = false,
    val searchCity : String = "",
    val weather: WeatherResponseModel? = null
)
