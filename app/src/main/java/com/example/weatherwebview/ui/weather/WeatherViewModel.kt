package com.example.weatherwebview.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherwebview.data.network.model.RemoteResult
import com.example.weatherwebview.domain.GetWeatherUseCase
import com.example.weatherwebview.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase): ViewModel() {
    val weatherModel = MutableLiveData<RemoteResult>()
    val error = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    suspend fun run() {
        viewModelScope.launch()
        {
            isLoading.postValue(true)
            when (val result = getWeatherUseCase()){
                is Resource.Success -> weatherModel.postValue(result.data)
                is Resource.Error -> error.postValue(result.message)
            }
            isLoading.postValue(false)
        }
    }

}