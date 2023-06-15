package com.example.listeddevtest.data.remote

import com.example.listeddevtest.data.remote.dto.DashboardDetailDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface DashBoardApi {

    @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")
    @GET("dashboardNew")
    suspend fun getDashboardDetails(): DashboardDetailDto

}