package com.example.weathertracker.data.repository

import android.app.Application
import coil3.network.HttpException
import com.example.weathertracker.R
import com.example.weathertracker.common.Result
import com.example.weathertracker.data.mapper.toWeather
import com.example.weathertracker.data.remote.WeatherApi
import com.example.weathertracker.domain.model.WeatherResponseModel
import com.example.weathertracker.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject


@Suppress("UNREACHABLE_CODE")
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val application: Application
) : WeatherRepository {

    override suspend fun getWeatherByName(
        apiKey: String,
        name: String
    ): Flow<Result<WeatherResponseModel>> {
        return flow {
            emit(Result.Loading(true))

            val remoteWeatherResultDto = try {
                weatherApi.getWeatherByName(apiKey = apiKey, query = name)
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            }catch (e:IOException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            }catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            }

            remoteWeatherResultDto.let { weatherResultDto ->
                weatherResultDto.let { weatherDto ->
                    emit(Result.Success(weatherDto.toWeather()))
                    emit(Result.Loading(false))
                    return@flow
                }
            }

            emit(Result.Error(application.getString(R.string.can_t_get_result)))
            emit(Result.Loading(false))
        }
    }
}