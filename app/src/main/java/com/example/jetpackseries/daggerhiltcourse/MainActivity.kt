package com.example.jetpackseries.daggerhiltcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackseries.daggerhiltcourse.ui.theme.JetpackSeriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackSeriesTheme {
//                val viewModel = hiltViewModel<MyViewModel>()

                Text(text = "hello world", style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}