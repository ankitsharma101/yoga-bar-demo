package com.example.yogabars.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.yogabars.ui.theme.components.BestSellerSection
import com.example.yogabars.ui.theme.components.BottomNavBar
import com.example.yogabars.ui.theme.components.CategoriesSection
import com.example.yogabars.ui.theme.components.InviteBanner
import com.example.yogabars.ui.theme.components.TopNavBar

@Composable
fun HomeScreen() {

    var selectedIndex by remember { mutableStateOf(0) }

    // 🛒 Cart state
    var cartItems by remember { mutableStateOf<Map<Int, Int>>(emptyMap()) }

    // total quantity for badge
    val totalCartCount = cartItems.values.sum()

    Scaffold(
        topBar = {
            TopNavBar(cartCount = totalCartCount)
        },
        bottomBar = {
            BottomNavBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            InviteBanner()
            CategoriesSection()

            BestSellerSection(
                cartItems = cartItems,
                onAddToCart = { id ->
                    cartItems = cartItems.toMutableMap().apply {
                        this[id] = (this[id] ?: 0) + 1
                    }
                },
                onRemoveFromCart = { id ->
                    cartItems = cartItems.toMutableMap().apply {
                        val current = this[id] ?: 0
                        if (current > 1) {
                            this[id] = current - 1
                        } else {
                            remove(id)
                        }
                    }
                }
            )
        }
    }
}