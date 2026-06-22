package com.prabash.prism.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prabash.prism.ui.apps.AppsScreen
import com.prabash.prism.ui.home.HomeScreen


@Composable
fun PrismNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.Apps.route) {
            AppsScreen()
        }
    }
}
