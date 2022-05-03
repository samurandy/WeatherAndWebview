package com.example.weatherwebview.ui.weather

import androidx.lifecycle.ViewModel
import com.example.weatherwebview.domain.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase): ViewModel() {


}