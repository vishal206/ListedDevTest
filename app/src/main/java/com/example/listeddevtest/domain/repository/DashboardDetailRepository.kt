package com.example.listeddevtest.domain.repository

import com.example.listeddevtest.common.Resource
import com.example.listeddevtest.data.remote.dto.DashboardDetailDto
import kotlinx.coroutines.flow.Flow

interface DashboardDetailRepository {
    suspend fun getDashboardDetails(): DashboardDetailDto
}