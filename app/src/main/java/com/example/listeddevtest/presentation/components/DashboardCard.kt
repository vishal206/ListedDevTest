package com.example.listeddevtest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.listeddevtest.R
import com.example.listeddevtest.presentation.ui.theme.cardBackground
import com.example.listeddevtest.presentation.ui.theme.clickBackground
import com.example.listeddevtest.presentation.ui.theme.textPrimary
import com.example.listeddevtest.presentation.ui.theme.textSecondary

@Composable
fun DashboardCard(
    title: String,
    value: String,
    imageDrawable: Int,
    iconBackground: Color
) {
    Column(
        modifier = Modifier
            .height(130.dp)
            .width(130.dp)
            .background(
                color = cardBackground,
                shape = MaterialTheme.shapes.small
            )
            .padding(10.dp),
//        verticalArrangement = Arrangement.Bottom

    ) {
        Image(
            painter = painterResource(id = imageDrawable),
            contentDescription = "hello",
            modifier = Modifier
                .size(42.dp)
                .background(
                    color = iconBackground,
                    shape = RoundedCornerShape(100.dp)
                )
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = value,
            color = textPrimary,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = title,
            color = textSecondary,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}