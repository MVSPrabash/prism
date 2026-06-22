package com.prabash.prism.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.toString
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prabash.prism.data.TrafficMonitor
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun HomeScreen() {
    val monitor = remember { TrafficMonitor() }

    var uploadSpeed by remember { mutableLongStateOf(0) }
    var downloadSpeed by remember { mutableLongStateOf(0) }

    var previousRx = monitor.getTotalRxBytes()
    var previousTx = monitor.getTotalTxBytes()

    LaunchedEffect(Unit) {
        while(true) {
            delay(1000.milliseconds)
            println("1000 ms done")

            val rx = monitor.getTotalRxBytes()
            val tx = monitor.getTotalTxBytes()

            downloadSpeed = rx - previousRx
            uploadSpeed = tx - previousTx

            previousRx = rx
            previousTx = tx
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        NetworkSpeedCard(
            title = "Download",
            speed = formatSpeed(downloadSpeed)
        )

        NetworkSpeedCard(
            title = "Upload",
            speed = formatSpeed(uploadSpeed)
        )
    }
}


fun formatSpeed(bytesPerSecond: Long): String {
    return when {
        bytesPerSecond < 1024 ->
            "$bytesPerSecond B/s"

        bytesPerSecond < 1024 * 1024 ->
            String.format("%.1f KB/s", bytesPerSecond / 1024.0)

        bytesPerSecond < 1024 * 1024 * 1024 ->
            String.format("%.1f MB/s", bytesPerSecond / (1024.0 * 1024))

        else ->
            String.format("%.1f GB/s", bytesPerSecond / (1024.0 * 1024 * 1024))
    }
}