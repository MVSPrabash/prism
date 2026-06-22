package com.prabash.prism.ui.apps

import android.content.pm.ApplicationInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AppsScreen() {
    val context = LocalContext.current
    val apps = remember { context.packageManager.getInstalledApplications(0) }
    var appNames = remember {
        apps.map {
            context.packageManager
                .getApplicationLabel(it)
                .toString()
        }
    }

    appNames = remember { appNames.sorted() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 0.dp)
        ,
    ) {
        items(appNames) {appName ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black, shape = RoundedCornerShape(8.dp))
            ) {
                Text(
                    appName,
                    modifier = Modifier.padding(5.dp)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}