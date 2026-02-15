package com.example.yogabars.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.yogabars.ui.theme.components.BannerSection
import com.example.yogabars.ui.theme.components.BestSellersSection
import com.example.yogabars.ui.theme.components.CategoriesSection
import com.example.yogabars.ui.theme.components.TopNavBar

@Composable
fun HomeScreen() {
    var selectedItem by remember { mutableStateOf(0) }
    var query by remember { mutableStateOf("") }

    var cartItems by remember { mutableStateOf(mapOf<Int, Int>()) }

    val cartCount = cartItems.values.sum()

    Scaffold(
        containerColor = Color(0xFFF5F5F5),
        topBar = {
            TopNavBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
        {
            item { BannerSection() }
            item { CategoriesSection() }
            item {
                BestSellersSection(
                    cartItems = cartItems,
                    onAddToCart = { productId ->
                        cartItems = cartItems.toMutableMap().apply {
                            this[productId] = (this[productId] ?: 0) + 1
                        }
                    },
                    onRemoveFromCart = { productId ->
                        cartItems = cartItems.toMutableMap().apply {
                            val currentQty = this[productId] ?: 0
                            if (currentQty > 1) {
                                this[productId] = currentQty - 1
                            } else remove(productId)
                        }
                    }
                )
            }
        }
    }
}
