package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.yogabars.R

@Composable
fun TopNavBar(
    cartCount: Int
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        color = Color(0xFFE91E63),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Left profile circle
            Surface(
                modifier = Modifier.size(40.dp),
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                Box(contentAlignment = Alignment.Center) {

                    Image(
                        painter = painterResource(id = R.drawable.app_logo),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            // Right icons
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(Icons.Default.Search, null, tint = Color.White)

                Icon(Icons.Default.Person, null, tint = Color.White)

                // 🛒 Cart with Badge
                Box {

                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Cart",
                        tint = Color.White,
                        modifier = Modifier.size(26.dp)
                    )

                    if (cartCount > 0) {

                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .align(Alignment.TopEnd)
                                .offset(x = 8.dp, y = (-10).dp)
                                .background(
                                    color = Color.White,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = if (cartCount > 9) "9+" else cartCount.toString(),
                                color = Color(0xFFE91E63),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 10.sp, // 👈 fixes vertical shift
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun NavItem(
    label: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {

        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) Color(0xFFE91E63) else Color.Gray
        )

        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) Color(0xFFE91E63) else Color.Gray
        )
    }
}
