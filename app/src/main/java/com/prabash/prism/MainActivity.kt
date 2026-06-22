package com.prabash.prism

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Apps
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prabash.prism.navigation.PrismNavHost
import com.prabash.prism.navigation.Screen
import com.prabash.prism.ui.theme.PrismTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            PrismTheme {
                Scaffold(
                    topBar = { TopAppBar(title = {Text("Prism")}) },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = currentRoute == Screen.Home.route,
                                onClick = {
                                    navController.navigate(Screen.Home.route) {
                                        launchSingleTop = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = null
                                    )
                                },
                                label = { Text("Home") }
                            )

                            NavigationBarItem(
                                selected = currentRoute == Screen.Apps.route,
                                onClick = {
                                    navController.navigate(Screen.Apps.route) {
                                        launchSingleTop = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Apps,
                                        contentDescription = null
                                    )
                                },
                                label = { Text("Apps") }
                            )
                        }
                    }
                ) { innerPadding ->

                    PrismNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
