package com.example.weatherwebview.domain

import com.example.weatherwebview.data.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {

    suspend operator fun invoke() = repository.getWeatherUseCase()
}