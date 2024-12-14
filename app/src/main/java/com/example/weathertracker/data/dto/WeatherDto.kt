package com.example.weathertracker.data.dto

data class WeatherDto(
    val current: CurrentDto? = null,
    val location: LocationDto? = null
)