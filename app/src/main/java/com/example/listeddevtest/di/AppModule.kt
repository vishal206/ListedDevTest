package com.example.listeddevtest.di

import com.example.listeddevtest.common.Constants
import com.example.listeddevtest.data.remote.DashBoardApi
import com.example.listeddevtest.data.repository.DashboardDetailImpl
import com.example.listeddevtest.domain.repository.DashboardDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDashboardApi(): DashBoardApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DashBoardApi::class.java)

    }

    @Provides
    @Singleton
    fun provideDashboardDetailRepository(api: DashBoardApi): DashboardDetailRepository {
        return DashboardDetailImpl(api)
    }
}