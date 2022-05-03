package com.example.weatherwebview.data

import com.example.weatherwebview.data.network.model.RemoteResult
import com.example.weatherwebview.utils.Resource
import com.example.weatherwebview.data.network.WeatherService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val service: WeatherService) {

    suspend fun getWeatherUseCase(): Resource<RemoteResult> {
        val result = service.getWeather()
        return when (result.data) {
            null -> Resource.Error(result.message ?: "Something went wrong")
            else -> Resource.Success(result.data)
        }
    }
}