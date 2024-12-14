package com.example.weathertracker.data.dto

data class LocationDto(
    val country: String? = null,
    val lat: Double? = null,
    val localtime: String? = null,
    val localtime_epoch: Int ?= null,
    val lon: Double? = null,
    val name: String? = null,
    val region: String? = null,
    val tz_id: String? = null
)