package com.example.listeddevtest.presentation.dashboard.dashboardTabs

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listeddevtest.data.remote.dto.TopLink
import com.example.listeddevtest.presentation.components.LinkCard
import com.example.listeddevtest.presentation.dashboard.DashboardViewModel
import com.example.listeddevtest.presentation.ui.theme.appSecondary

@Composable
fun TopLinkScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val data = state.dashboardDetail?.data
    val TAG = "topLink"

    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
    ) {
        if (data != null) {
            items(data.top_links) { top_link ->
                LinkCard(
                    image = top_link.original_image,
                    app = top_link.app,
                    createdAt = top_link.created_at,
                    clicks = top_link.total_clicks,
                    webLink = top_link.web_link
                )
            }
        }
    }


}