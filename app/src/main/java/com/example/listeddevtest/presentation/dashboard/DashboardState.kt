package com.example.listeddevtest.presentation.dashboard

import com.example.listeddevtest.data.remote.dto.DashboardDetailDto
import com.example.listeddevtest.domain.model.DashboardDetail

data class DashboardState(
    val isLoading: Boolean = false,
    val dashboardDetail: DashboardDetail? = null,
    val error: String = ""

)
