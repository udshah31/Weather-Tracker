package com.example.weathertracker.domain.model

data class WeatherResponseModel(
    val current: CurrentModel,
    val location: LocationModel
)