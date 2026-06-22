package com.prabash.prism.data

import android.net.TrafficStats

class TrafficMonitor {
    fun getTotalRxBytes(): Long = TrafficStats.getTotalRxBytes()
    fun getTotalTxBytes(): Long = TrafficStats.getTotalTxBytes()
}
