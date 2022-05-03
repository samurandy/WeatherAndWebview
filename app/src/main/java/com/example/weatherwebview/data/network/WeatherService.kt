package com.example.weatherwebview.data.network

import com.example.weatherwebview.data.network.model.RemoteResult
import com.example.weatherwebview.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class WeatherService @Inject constructor(private val api: RemoteService) {

    suspend fun getWeather(): Resource<RemoteResult> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<RemoteResult> = api.getWeather()
                Resource.Success(response.body()
                    ?: RemoteResult(
                        null, null, null, null, null,
                        arrayListOf(), arrayListOf(), arrayListOf()
                    ))

            } catch (e: Exception) {
                Resource.Error("There was a problem in the server")
            }
        }
    }
}