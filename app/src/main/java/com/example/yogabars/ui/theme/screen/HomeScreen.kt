package com.example.yogabars.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.yogabars.ui.theme.components.BannerSection
import com.example.yogabars.ui.theme.components.BestSellerSection
import com.example.yogabars.ui.theme.components.BottomNavBar
import com.example.yogabars.ui.theme.components.CategoriesSection
import com.example.yogabars.ui.theme.components.InviteBanner
import com.example.yogabars.ui.theme.components.TopNavBar

@Composable
fun HomeScreen() {

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { TopNavBar() },
        bottomBar = {
            BottomNavBar(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            // ✅ Invite banner FIRST
            InviteBanner()

            // Categories section
            CategoriesSection()

            // Best Sellers
            BestSellerSection(
                cartItems = emptyMap(),
                onAddToCart = {},
                onRemoveFromCart = {}
            )
        }
    }
}


