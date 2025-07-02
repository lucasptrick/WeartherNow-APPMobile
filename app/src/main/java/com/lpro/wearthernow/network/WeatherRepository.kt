package com.lpro.wearthernow.network

import com.lpro.wearthernow.model.WeatherResponse

class WeatherRepository {
    suspend fun getByCity(city: String): WeatherResponse =
        RetrofitClient.api.currentByCity(city)
}
