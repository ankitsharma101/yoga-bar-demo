package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yogabars.R

@Composable
fun TopNavBar(
    selectedItem: Int,
    onItemSelected:(Int)-> Unit
){
    NavigationBar(
        modifier = Modifier.statusBarsPadding(),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ){
        NavigationBarItem(
            selected = selectedItem==0,
            onClick = {onItemSelected(0)},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Icon(
                        imageVector = if(selectedItem==0) Icons.Filled.Home else Icons.Outlined.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Home",
                        fontSize = 12.sp,
                        fontWeight = if(selectedItem==0) FontWeight.Bold else FontWeight.Normal
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE64A19),
                selectedTextColor = Color(0xFFE64A19),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )

        )
        NavigationBarItem(
            selected = selectedItem==1,
            onClick = {onItemSelected(1)},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_apps_24),
                        contentDescription = "Shop",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Shop",
                        fontSize = 12.sp,
                        fontWeight = if(selectedItem==0) FontWeight.Bold else FontWeight.Normal
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE64A19),
                selectedTextColor = Color(0xFFE64A19),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedItem==2,
            onClick = {onItemSelected(2)},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Icon(
                        painter =painterResource(R.drawable.outline_calendar_today_24) ,
                        contentDescription = "Subscription",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Subscription",
                        fontSize = 12.sp,
                        fontWeight = if(selectedItem==0) FontWeight.Bold else FontWeight.Normal
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE64A19),
                selectedTextColor = Color(0xFFE64A19),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedItem==3,
            onClick = {onItemSelected(3)},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Icon(
                        imageVector = if(selectedItem==3) Icons.Filled.AccountBox else Icons.Outlined.AccountBox,
                        contentDescription = "Account",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Profile",
                        fontSize = 12.sp,
                        fontWeight = if(selectedItem==0) FontWeight.Bold else FontWeight.Normal
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE64A19),
                selectedTextColor = Color(0xFFE64A19),
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )
    }
}

