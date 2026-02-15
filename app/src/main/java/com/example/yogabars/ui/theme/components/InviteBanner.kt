package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yogabars.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment





@Composable
fun InviteBanner() {

    val pagerState = rememberPagerState(pageCount = { 3 })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) { page ->

        val imageRes = when (page) {
            0 -> R.drawable.banner1
            1 -> R.drawable.banner2
            else -> R.drawable.banner3
        }

        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Banner",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
            )


            // Bottom Row (Button + Dots)
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 110.dp, bottom = 50                                                                                                  .dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Dots
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(3) { index ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 3.dp)
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(
                                    if (pagerState.currentPage == index)
                                        Color(0xFFE91E63)
                                    else
                                        Color(0xFFFFFFFF).copy(alpha = 0.4f)
                                )
                        )
                    }
                }
            }
        }
    }
}
