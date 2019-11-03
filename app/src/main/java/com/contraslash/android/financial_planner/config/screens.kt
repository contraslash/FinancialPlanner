package com.contraslash.android.financial_planner.config

import androidx.compose.Model

sealed class Screen {
    object Home : Screen()
    object SMS : Screen()
}

@Model
object MainStore {
    var currentScreen: Screen = Screen.Home
}

fun navigateTo(destination: Screen) {
    MainStore.currentScreen = destination
}