package com.prabash.prism.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

@Composable
fun NetworkSpeedCard(
    title: String,
    speed: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
        ,
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = speed,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}