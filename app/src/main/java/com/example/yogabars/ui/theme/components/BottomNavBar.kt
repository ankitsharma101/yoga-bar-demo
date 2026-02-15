package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {

    Box {

        NavigationBar(
            containerColor = Color.White
        ) {

            NavigationBarItem(
                selected = selectedIndex == 0,
                onClick = { onItemSelected(0) },
                icon = { Icon(Icons.Default.Home, null) },
                label = { Text("HOME") }
            )

            NavigationBarItem(
                selected = selectedIndex == 1,
                onClick = { onItemSelected(1) },
                icon = { Icon(Icons.Default.Store, null) },
                label = { Text("SHOP") }
            )

            Spacer(modifier = Modifier.weight(1f, true))

            NavigationBarItem(
                selected = selectedIndex == 3,
                onClick = { onItemSelected(3) },
                icon = { Icon(Icons.Default.LocalOffer, null) },
                label = { Text("OFFERS") }
            )

            NavigationBarItem(
                selected = selectedIndex == 4,
                onClick = { onItemSelected(4) },
                icon = { Icon(Icons.Default.Person, null) },
                label = { Text("PROFILE") }
            )
        }

        Surface(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-20).dp),
            shape = CircleShape,
            color = Color.White,
            shadowElevation = 12.dp
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .size(54.dp)
                        .clickable { onItemSelected(2) },
                    shape = CircleShape,
                    color = Color(0xFFE91E63)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            Icons.Default.FlashOn,
                            contentDescription = "Wellness",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
