package com.example.listeddevtest.presentation.components


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listeddevtest.presentation.dashboard.DashboardViewModel
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot
import java.util.Collections
import java.util.stream.Collectors

@SuppressLint("SuspiciousIndentation")
@Composable
fun Graph(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val TAG = "graph"
    val state = viewModel.state.value;
    val monthValueMap: HashMap<Int, Int> = HashMap()
    for (i in 0..11) {
        monthValueMap.put(i, 0)
    }
    val xValues = listOf<Int>(
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
    )

    val monthList = listOf<String>(
        "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
        "DEC"
    )

    val overallUrlChart = state.dashboardDetail?.data?.overall_url_chart
    if (overallUrlChart != null) {
        for (item in overallUrlChart.entries.iterator()) {
            val date = item.key
            val month = date.split("-").get(1).toInt()

            monthValueMap.put(month, monthValueMap.get(month)?.plus(item.value) ?: 0)

        }
        Log.d(TAG, ": ${monthValueMap.toString()}")


        val dataPoints: MutableList<DataPoint> = mutableListOf<DataPoint>()
        for (item in xValues) {
            if (monthValueMap.get(item) != null)
                dataPoints.add(DataPoint(item.toFloat(), monthValueMap.get(item)!!.toFloat()));
        }

        LineGraph(
            plot = LinePlot(
                listOf(
                    LinePlot.Line(
                        dataPoints,
                        LinePlot.Connection(Color.Magenta, 2.dp),
                        LinePlot.Intersection(Color.Magenta, 2.dp),
                        LinePlot.Highlight(Color.Magenta, 2.dp),
                        LinePlot.AreaUnderLine(Color.Magenta, 0.3f),
                    )
                ),

                xAxis = LinePlot.XAxis(
                    stepSize = 20.dp,
                    steps = 12,
                    unit = 1f,
                ){ min, offset, max ->
                    for(i in 0 until 12){
                        androidx.compose.foundation.layout.Column() {
                            Text(text = monthList.get(i))
                        }
                    }
                },
                horizontalExtraSpace = 14.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

    }
}