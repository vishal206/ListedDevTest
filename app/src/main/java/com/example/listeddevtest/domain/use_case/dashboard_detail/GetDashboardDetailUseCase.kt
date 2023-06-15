package com.example.listeddevtest.domain.use_case.dashboard_detail

import android.util.Log
import com.example.listeddevtest.common.Resource
import com.example.listeddevtest.data.remote.dto.toDashboardDetail
import com.example.listeddevtest.domain.model.DashboardDetail
import com.example.listeddevtest.domain.repository.DashboardDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetDashboardDetailUseCase @Inject constructor(
    private val repository: DashboardDetailRepository
) {
    val TAG = "DashUC"

    operator fun invoke(): Flow<Resource<DashboardDetail>> = flow {

        try{

            emit(Resource.Loading<DashboardDetail>())
            val dashboardDetail=repository.getDashboardDetails().toDashboardDetail()


            emit(Resource.Success<DashboardDetail>(dashboardDetail))
        }catch (e: HttpException){
            emit(Resource.Error<DashboardDetail>(e.localizedMessage?:"An unexpected error occurred"))
        } catch(e: IOException){
            emit(Resource.Error<DashboardDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}