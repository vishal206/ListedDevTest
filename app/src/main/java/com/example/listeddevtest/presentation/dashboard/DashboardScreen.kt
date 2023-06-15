package com.example.listeddevtest.presentation.dashboard

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listeddevtest.presentation.ui.theme.ListedDevTestTheme

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val TAG = "DashboardScreen"
    val state = viewModel.state.value
    Text(
        text = "Dashboard",
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Left,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    )

    Log.d(TAG, ": here:)")
    Log.d(TAG, state.toString())
}

//@Preview(showBackground = true)
//@Composable
//fun DashboardPreview() {
//    ListedDevTestTheme {
//        DashboardScreen()
//    }
//}