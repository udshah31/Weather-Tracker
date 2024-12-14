package com.example.weathertracker.di

import com.example.weathertracker.data.repository.WeatherRepositoryImpl
import com.example.weathertracker.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindDictionaryRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ):WeatherRepository
}