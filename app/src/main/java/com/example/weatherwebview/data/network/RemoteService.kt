package com.example.weatherwebview.data.network

import com.example.weatherwebview.data.network.model.RemoteResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {
    companion object{
        const val latitude: String = "51.274424298528906"
        const val longitude: String = "6.862137434544318"
        const val apiKey: String = "5c3f77686f3e0c2c477e729384327ebb"
        const val exclude: String = "minutely,hourly"
        const val units: String = "metric"
    }

    @GET("onecall")
    suspend fun getWeather(
        @Query("lat") latitude: String = RemoteService.latitude,
        @Query("lon") longitude: String = RemoteService.longitude,
        @Query("exclude") exclude: String = RemoteService.exclude,
        @Query("units") units: String = RemoteService.units,
        @Query("appid") apiKey: String = RemoteService.apiKey

    ): Response<RemoteResult>
}