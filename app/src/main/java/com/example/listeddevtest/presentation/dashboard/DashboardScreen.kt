package com.example.listeddevtest.presentation.dashboard

import android.util.Log
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Tab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.TabRow
import androidx.compose.material3.Divider
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listeddevtest.R
import com.example.listeddevtest.presentation.components.DashboardCard
import com.example.listeddevtest.presentation.components.Graph
import com.example.listeddevtest.presentation.dashboard.dashboardTabs.RecentLinkScreen
import com.example.listeddevtest.presentation.dashboard.dashboardTabs.TopLinkScreen
import com.example.listeddevtest.presentation.ui.theme.Denim
import com.example.listeddevtest.presentation.ui.theme.ListedDevTestTheme
import com.example.listeddevtest.presentation.ui.theme.Malibu
import com.example.listeddevtest.presentation.ui.theme.appBackground
import com.example.listeddevtest.presentation.ui.theme.appPrimary
import com.example.listeddevtest.presentation.ui.theme.appSecondary
import com.example.listeddevtest.presentation.ui.theme.appWhite
import com.example.listeddevtest.presentation.ui.theme.cardBackground
import com.example.listeddevtest.presentation.ui.theme.clickBackground
import com.example.listeddevtest.presentation.ui.theme.globeBackground
import com.example.listeddevtest.presentation.ui.theme.pinBackground
import com.example.listeddevtest.presentation.ui.theme.primaryBackground
import com.example.listeddevtest.presentation.ui.theme.settingBackground
import com.example.listeddevtest.presentation.ui.theme.textPrimary
import com.example.listeddevtest.presentation.ui.theme.textSecondary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val TAG = "DashboardScreen"
    val state = viewModel.state.value
    val tabItems = listOf("Top Links", "Recent Links")
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = appPrimary
            )
    ) {

        item {
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(
                    text = "Dashboard",
                    style = MaterialTheme.typography.titleMedium,
                    color = appWhite
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = settingBackground,
                            shape = MaterialTheme.shapes.small
                        )

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wrench),
                        contentDescription = "setting",
                        modifier = Modifier
                            .size(42.dp)
                            .padding(8.dp),
                    )
                }
            }


            Column(
                modifier = Modifier
                    .background(
                        color = appBackground,
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                    )
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = "Good morning",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = textSecondary
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ajay Manva",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Left,

                        color = textPrimary
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    Image(
                        painter = painterResource(id = R.drawable.hello2),
                        contentDescription = "hello",
                        modifier = Modifier
                            .size(36.dp)
                    )
                }

                Spacer(modifier = Modifier.size(15.dp))

                Column(
                    modifier = Modifier
                        .background(
                            color = cardBackground,
                            shape = MaterialTheme.shapes.small
                        )
                        .fillMaxSize()
                        .padding(0.dp, 5.dp)

                ) {
                    Row(
                        modifier = Modifier
                            .padding(10.dp, 10.dp, 10.dp, 5.dp)
                            .fillMaxWidth(),
                        Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Overview",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Left,

                            color = textSecondary

                        )

                        Row(
                            modifier = Modifier
                                .border(
                                    width = 1.2.dp,
                                    color = appSecondary,
                                    shape = MaterialTheme.shapes.small
                                )
                                .background(
                                    color = Color.Transparent
                                )
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "22 Aug - 23 Sept",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(0.dp, 0.dp, 5.dp, 0.dp),
                                color = textPrimary

                            )
//                            Spacer(modifier = Modifier.size(2.dp))
                            Image(
                                painter = painterResource(id = R.drawable.clock),
                                contentDescription = "clock",
                                modifier = Modifier
                                    .size(16.dp),
                            )
                        }
                    }


                    Graph()
                    //LazyRow

                }

                Spacer(modifier = Modifier.size(24.dp))

                LazyRow(
                )
                {
                    items(1) {
                        DashboardCard(
                            "Today's Clicks",
                            state.dashboardDetail?.today_clicks.toString(),
                            R.drawable.click,
                            clickBackground
                        )
                        Spacer(modifier = Modifier.size(15.dp))
                        DashboardCard(
                            "Top Location",
                            state.dashboardDetail?.top_location.toString(),
                            R.drawable.pin,
                            pinBackground
                        )
                        Spacer(modifier = Modifier.size(15.dp))
                        DashboardCard(
                            "Top Source", state.dashboardDetail?.top_source.toString(),
                            R.drawable.globe,
                            globeBackground
                        )
                        Spacer(modifier = Modifier.size(15.dp))
                        DashboardCard(
                            "Total Clicks",
                            state.dashboardDetail?.total_clicks.toString(),
                            R.drawable.click,
                            clickBackground
                        )
                        Spacer(modifier = Modifier.size(15.dp))
                        DashboardCard(
                            "Total Links", state.dashboardDetail?.total_links.toString(),
                            R.drawable.click,
                            clickBackground
                        )

                    }

                }

                Spacer(modifier = Modifier.size(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.2.dp,
                            color = appSecondary,
                            shape = MaterialTheme.shapes.small
                        )
                        .background(
                            color = Color.Transparent
                        )
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.price_boost),
                        contentDescription = "price boost",
                        modifier = Modifier
                            .size(24.dp),
                        alignment = Alignment.Center
                    )
                    Text(
                        text = "View Analytics",
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(14.dp, 5.dp),
                        color = textPrimary

                    )
                }
                Spacer(modifier = Modifier.size(32.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        backgroundColor = Color.Transparent,
                        modifier = Modifier
                            .background(color = Color.Transparent)
                            .clip(RoundedCornerShape(30.dp))
                            .width(280.dp),
                        indicator = { tabPositions ->
                            androidx.compose.material.TabRowDefaults.Indicator(
                                Modifier
                                    .pagerTabIndicatorOffset(
                                        pagerState, tabPositions
                                    )
                                    .width(0.dp)
                                    .height(0.dp)
                            )
                        },
                        divider = {
                            Divider(
                                color = Color.Transparent,
                                thickness = 0.dp
                            )
                        }
                    ) {
                        tabItems.forEachIndexed { index, title ->
                            val color = remember {
                                Animatable(Denim)
                            }

                            LaunchedEffect(
                                pagerState.currentPage == index
                            ) {
                                color.animateTo(if (pagerState.currentPage == index) appPrimary else Color.Transparent)
                            }
                            Tab(
                                text = {
                                    androidx.compose.material.Text(
                                        title,
                                        style = if (pagerState.currentPage == index) TextStyle(
                                            color = appWhite,
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.SemiBold
                                        ) else TextStyle(
                                            color = textSecondary, fontSize = 18.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    )
                                },
                                selected = pagerState.currentPage == index,
                                modifier = Modifier.background(
                                    color = color.value,
                                    shape = RoundedCornerShape(30.dp)
                                ),
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                }
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .background(
                                color = appBackground
                            )
                            .border(
                                width = 1.dp,
                                color = appSecondary,
                                shape = MaterialTheme.shapes.small
                            )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "search",
                            modifier = Modifier
                                .size(36.dp)
                                .padding(8.dp),
                        )
                    }

                }
                Spacer(modifier = Modifier.size(24.dp))
                HorizontalPager(
                    count = tabItems.size,
                    state = pagerState,
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .fillMaxWidth()
                        .height(800.dp)
                ) { index ->
                    when (index) {
                        0 -> TopLinkScreen()
                        1 -> RecentLinkScreen()
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.2.dp,
                            color = appSecondary,
                            shape = MaterialTheme.shapes.small
                        )
                        .background(
                            color = Color.Transparent
                        )
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.link),
                        contentDescription = "price boost",
                        modifier = Modifier
                            .size(24.dp),
                        alignment = Alignment.Center
                    )
                    Text(
                        text = "View all Links",
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(14.dp, 5.dp),
                        color = textPrimary

                    )
                }

                Spacer(modifier = Modifier.size(42.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.2.dp,
                            color = appPrimary,
                            shape = MaterialTheme.shapes.small
                        )
                        .background(
                            color = primaryBackground
                        )
                        .padding(12.dp, 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.whatsapp),
                        contentDescription = "whatsapp",
                        modifier = Modifier
                            .size(32.dp),
                        alignment = Alignment.Center
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = "Talk with us",
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(10.dp),
                        color = textPrimary

                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.2.dp,
                            color = appPrimary,
                            shape = MaterialTheme.shapes.small
                        )
                        .background(
                            color = primaryBackground
                        )
                        .padding(12.dp, 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.question_mark),
                        contentDescription = "Question",
                        modifier = Modifier
                            .size(32.dp),
                        alignment = Alignment.Center
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = "Frequently Asked Questions",
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(10.dp),
                        color = textPrimary

                    )
                }

            }
        }
    }
}



