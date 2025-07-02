package com.lpro.wearthernow.model

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather: List<WeatherItem>,
    val wind: Wind?,
    val clouds: Clouds?,
    val sys: Sys?
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)

data class WeatherItem(
    val icon: String,
    val description: String
)

data class Wind(val speed: Double, val deg: Int)
data class Clouds(val all: Int)
data class Sys(val country: String, val sunrise: Long, val sunset: Long)
