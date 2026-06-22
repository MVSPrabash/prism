package com.prabash.prism.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        NetworkSpeedCard(
            title = "Download",
            speed = "10 Mbps"
        )

        NetworkSpeedCard(
            title = "Upload",
            speed = "5 Mbps"
        )
    }
}