package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
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

@Composable
fun TopNavBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        contentAlignment = Alignment.Center
    ) {

        // Background Bar
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                //bottomStart = 24.dp,
                //bottomEnd = 24.dp
            )
            ,
            color = Color.White,
            shadowElevation = 6.dp
        ) {

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                NavItem("HOME", Icons.Default.Home, selectedItem == 0) {
                    onItemSelected(0)
                }

                NavItem("SHOP", Icons.Default.Shop, selectedItem == 1) {
                    onItemSelected(1)
                }

                Spacer(modifier = Modifier.width(60.dp)) // space for center button

                NavItem("OFFERS", Icons.Default.LocalOffer, selectedItem == 3)
                {
                    onItemSelected(3)
                }

                NavItem("PROFILE", Icons.Default.Person, selectedItem == 4) {
                    onItemSelected(4)
                }
            }
        }

        // ⭐ Center Floating Button
        Surface(
            modifier = Modifier
                .size(70.dp)
                .offset(y = (-20).dp)
                .border(2.dp, Color.White, CircleShape), // Border
            shape = CircleShape,
            color = Color(0xFFE91E63),
            shadowElevation = 8.dp
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable { onItemSelected(2) }
            ) {
                Icon(
                    imageVector = Icons.Default.FlashOn,
                    contentDescription = "Wellness",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
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
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            color = if (selected) Color(0xFFE91E63) else Color.Gray
        )
    }
}



