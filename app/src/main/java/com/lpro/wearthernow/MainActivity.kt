package com.lpro.wearthernow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import com.lpro.wearthernow.ui.WeatherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Preenche o ComposeView
        findViewById<ComposeView>(R.id.compose_slot).setContent {
            MaterialTheme {
                WeatherScreen()
            }
        }
    }
}

