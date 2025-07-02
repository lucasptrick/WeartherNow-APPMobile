package com.lpro.wearthernow.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lpro.wearthernow.model.WeatherResponse
import com.lpro.wearthernow.view.WeatherViewModel


@Composable
fun WeatherScreen(vm: WeatherViewModel = viewModel()) {
    var city by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Cidade") }
        )
        Button(
            onClick = { vm.load(city) },
            enabled = city.isNotBlank()
        ) { Text("Buscar") }

        when {
            vm.error != null   -> Text(vm.error!!, color = Color.Red)
            vm.uiState != null -> WeatherCard(vm.uiState!!)
        }
    }
}

@Composable
fun WeatherCard(data: WeatherResponse) {
    Column(Modifier.padding(top = 16.dp)) {
        Text(text = data.name)
        Text(text = "${data.main.temp} °C")
        Text(text = data.weather.firstOrNull()?.description ?: "")
        Text(text = "Umidade: ${data.main.humidity}%")
    }
}

