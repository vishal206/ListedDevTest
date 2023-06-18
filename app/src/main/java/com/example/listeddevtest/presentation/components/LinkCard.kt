package com.example.listeddevtest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.listeddevtest.R
import com.example.listeddevtest.presentation.ui.theme.Malibu
import com.example.listeddevtest.presentation.ui.theme.appPrimary
import com.example.listeddevtest.presentation.ui.theme.appSecondary
import com.example.listeddevtest.presentation.ui.theme.cardBackground
import com.example.listeddevtest.presentation.ui.theme.primaryBackground
import com.example.listeddevtest.presentation.ui.theme.textPrimary
import com.example.listeddevtest.presentation.ui.theme.textSecondary

@Composable
fun LinkCard(
    image: String=" ",
    app: String=" ",
    createdAt: String=" ",
    clicks: Int=0,
    webLink: String=" "
    ){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,10.dp)
            .background(
                color = cardBackground,
                shape = MaterialTheme.shapes.small
            )
            .clip(RoundedCornerShape(8.dp)),


    ) {
        val stroke = Stroke(width = 2f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(15.dp,20.dp,20.dp,20.dp),

        ) {
            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(color= Color.Transparent)
                    .fillMaxWidth()
                ,
                contentScale = ContentScale.Crop
            )

            Column(
               horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(10.dp,0.dp)
            ){
                Text(
                    text = (app+"").capitalize(),
                    color = textPrimary,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = createdAt.substring(0,10),
                    color = textSecondary,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = "$clicks",
                    color = textPrimary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = "Clicks",
                    color = textSecondary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .background(
                    color = primaryBackground,
                )
                .drawBehind {
                    drawRoundRect(color = appPrimary, style = stroke)
                }
                .padding(10.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = webLink,
                color = appPrimary,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(230.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.copy),
                contentDescription = "copy",
                modifier = Modifier
                    .size(16.dp),
            )
        }

    }
}