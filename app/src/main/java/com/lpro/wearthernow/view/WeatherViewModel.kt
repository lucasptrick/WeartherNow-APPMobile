package com.lpro.wearthernow.view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lpro.wearthernow.model.WeatherResponse
import com.lpro.wearthernow.network.WeatherRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class WeatherViewModel(
    private val repo: WeatherRepository = WeatherRepository()
) : ViewModel() {

    var uiState by mutableStateOf<WeatherResponse?>(null)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun load(city: String) {
        viewModelScope.launch {
            try {
                uiState = repo.getByCity(city)
                error = null
            } catch (e: Exception) {
                when (e) {
                    is HttpException -> {
                        Log.e("WEATHER", "HTTP ${e.code()} body=${e.response()?.errorBody()?.string()}")
                        error = when (e.code()) {
                            404 -> "Cidade não encontrada"
                            401 -> "API key inválida"
                            else -> "Erro do servidor: ${e.code()}"
                        }
                    }
                    else -> {
                        Log.e("WEATHER", "Erro genérico", e)
                        error = "Erro de rede: ${e.localizedMessage}"
                    }
                }
            }

        }
    }
}
