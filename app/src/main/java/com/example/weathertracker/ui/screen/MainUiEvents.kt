package com.example.weathertracker.ui.screen

sealed class MainUiEvents {
    data class OnSearchCityChange(
        val newWord: String
    ):MainUiEvents()

    object onSearchClick : MainUiEvents()
}
