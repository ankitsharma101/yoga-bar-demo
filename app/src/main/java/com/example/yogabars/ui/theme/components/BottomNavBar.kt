package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.yogabars.R

@Composable
fun BottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {

    Box {

        Surface(
            shape = RoundedCornerShape(
                topStart = 28.dp,
                topEnd = 28.dp
            ),
            color = Color.White,
            shadowElevation = 5.dp
        ) {

            NavigationBar(
                containerColor = Color.Transparent,
                tonalElevation = 0.dp
            ) {

                NavigationBarItem(
                    selected = selectedIndex == 0,
                    onClick = { onItemSelected(0) },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("HOME", fontSize = 11.sp) },
                    colors = navItemColors()
                )

                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = { onItemSelected(1) },
                    icon = { Icon(Icons.Default.Store, contentDescription = "Shop") },
                    label = { Text("SHOP", fontSize = 11.sp) },
                    colors = navItemColors()
                )

                Spacer(modifier = Modifier.weight(1f))

                NavigationBarItem(
                    selected = selectedIndex == 3,
                    onClick = { onItemSelected(3) },
                    icon = { Icon(Icons.Default.LocalOffer, contentDescription = "Offers") },
                    label = { Text("OFFERS", fontSize = 11.sp) },
                    colors = navItemColors()
                )

                NavigationBarItem(
                    selected = selectedIndex == 4,
                    onClick = { onItemSelected(4) },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("PROFILE", fontSize = 11.sp) },
                    colors = navItemColors()
                )
            }
        }

        // Center Button
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-26).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier.size(58.dp),
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 5.dp
            ) {
                Box(contentAlignment = Alignment.Center) {

                    Surface(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable { onItemSelected(2) },
                        shape = CircleShape,
                        color = Color(0xFFE91E63)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = R.drawable.wellness_icon),
                                contentDescription = "Wellness",
                                modifier = Modifier.size(64.dp),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                }
            }

            Text(
                text = "WELLNESS",
                fontSize = 11.sp,
                color = if (selectedIndex == 2)
                    Color(0xFFE91E63) else Color(0xFF9E9E9E)
            )
        }
    }
}

@Composable
private fun navItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = Color(0xFFE91E63),
    selectedTextColor = Color(0xFFE91E63),
    unselectedIconColor = Color(0xFF9E9E9E),
    unselectedTextColor = Color(0xFF9E9E9E),
    indicatorColor = Color.Transparent
)