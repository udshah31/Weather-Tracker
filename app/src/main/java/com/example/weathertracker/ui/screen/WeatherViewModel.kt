package com.example.weathertracker.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertracker.common.Constants
import com.example.weathertracker.common.Result
import com.example.weathertracker.domain.repository.DatastoreRepo
import com.example.weathertracker.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val datastoreRepo: DatastoreRepo
) : ViewModel() {

    private val _weatherState = MutableStateFlow(WeatherState())
    val weatherState = _weatherState.asStateFlow()

    private var searchJob: Job? = null


    init {
        _weatherState.update {
            it.copy(searchCity = "london")
        }

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            loadWeatherResult()
        }
    }

    fun onEvent(mainUiEvents: MainUiEvents) {
        when (mainUiEvents) {
            MainUiEvents.onSearchClick -> {

                searchJob?.cancel()

                searchJob = viewModelScope.launch {
                    loadWeatherResult()
                }
            }


            is MainUiEvents.OnSearchCityChange -> {
                _weatherState.update {
                    it.copy(
                        searchCity = mainUiEvents.newWord.lowercase()
                    )
                }

            }

        }
    }

    private fun loadWeatherResult() {
        viewModelScope.launch {
            repository.getWeatherByName(
                Constants.API_KEY, name = weatherState.value.searchCity
            ).collect { result ->
                when (result) {
                    is Result.Error -> Unit

                    is Result.Loading -> {
                        _weatherState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }

                    is Result.Success -> {
                        result.data?.let { weather ->
                            _weatherState.update {
                                it.copy(
                                    weather = weather
                                )
                            }
                        }
                    }
                }
            }
        }
    }

     fun storeCityData(
        city: String,
        temp: String,
        icon: String,
        hasData: Boolean
    ) = runBlocking {
        datastoreRepo.putString(Constants.CITY_NAME, city)
        datastoreRepo.putString(Constants.CITY_TEMP_KEY, temp)
        datastoreRepo.putString(Constants.CITY_ICON_KEY, icon)
        datastoreRepo.putBoolean(Constants.HAS_DATA, hasData)
    }

    fun getStoreCityNameData(): String? = runBlocking {
        datastoreRepo.getString(Constants.CITY_NAME)
    }

    fun getStoreCityTempData(): String? = runBlocking {
        datastoreRepo.getString(Constants.CITY_TEMP_KEY)
    }

    fun getStoreCityIconData(): String? = runBlocking {
        datastoreRepo.getString(Constants.CITY_ICON_KEY)
    }

    fun getStoreHasData(): Boolean? = runBlocking {
        datastoreRepo.getBoolean(Constants.HAS_DATA)
    }

    fun clearCityData() = runBlocking {
        datastoreRepo.clearPReferences(Constants.CITY_NAME)
        datastoreRepo.clearPReferences(Constants.CITY_TEMP_KEY)
        datastoreRepo.clearPReferences(Constants.CITY_ICON_KEY)
    }

}