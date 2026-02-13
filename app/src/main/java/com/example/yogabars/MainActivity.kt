package com.example.yogabars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.yogabars.ui.theme.YogaBarsTheme
import com.example.yogabars.ui.theme.screen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YogaBarsTheme {
                HomeScreen()
            }
        }
    }
}