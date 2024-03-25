package com.example.movie.ui

import androidx.compose.runtime.Composable
import com.example.movie.ui.theme.AppTheme

class App {
    @Composable
    fun Content(darkTheme: Boolean, hostNode: @Composable () -> Unit) {

        AppTheme(
            useDarkTheme = darkTheme
        ) {
            hostNode()
        }
    }
}