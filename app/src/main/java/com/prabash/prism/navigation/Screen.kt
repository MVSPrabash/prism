package com.prabash.prism.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")

    data object Apps : Screen("apps")
}