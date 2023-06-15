package com.example.listeddevtest.data.repository

import com.example.listeddevtest.data.remote.DashBoardApi
import com.example.listeddevtest.data.remote.dto.DashboardDetailDto
import com.example.listeddevtest.domain.repository.DashboardDetailRepository
import javax.inject.Inject

class DashboardDetailImpl @Inject constructor(
    private val api: DashBoardApi
) : DashboardDetailRepository {

    override suspend fun getDashboardDetails(): DashboardDetailDto {
        return api.getDashboardDetails()
    }

}