package com.example.listeddevtest.presentation.dashboard

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listeddevtest.common.Resource
import com.example.listeddevtest.domain.repository.DashboardDetailRepository
import com.example.listeddevtest.domain.use_case.dashboard_detail.GetDashboardDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getDasboardDetailUseCase: GetDashboardDetailUseCase
) : ViewModel() {
    private val _state = mutableStateOf(DashboardState())
    val state: State<DashboardState> = _state
    val TAG = "viewMod"

    init {
        getDashboardDetail()
    }

    private fun getDashboardDetail() {
        getDasboardDetailUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = DashboardState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading -> {
                    _state.value = DashboardState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = DashboardState(dashboardDetail = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }


}