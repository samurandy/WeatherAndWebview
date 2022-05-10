package com.example.weatherwebview.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherwebview.data.network.model.RemoteResult
import com.example.weatherwebview.domain.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            _state.value = UiState(weather = getWeatherUseCase().data)
            _state.value = UiState(error = getWeatherUseCase().message)
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val weather: RemoteResult? = null,
        val error: String? = null
    )
}