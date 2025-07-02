package com.lpro.wearthernow.network

import com.lpro.wearthernow.BuildConfig
import com.lpro.wearthernow.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather")
    suspend fun currentByCity(
        @Query("q") city: String? = null,
        @Query("id") id: Int? = null,
        @Query("lat") lat: Double? = null,
        @Query("lon") lon: Double? = null,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "pt_br",
        @Query("appid") apiKey: String = BuildConfig.OWM_KEY
    ): WeatherResponse

}
