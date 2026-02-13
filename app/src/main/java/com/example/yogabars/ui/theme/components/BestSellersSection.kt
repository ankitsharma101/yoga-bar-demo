package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yogabars.R

data class Product(
    val id: Int,
    val title: String,
    val rating: Double,
    val ratingCount: Int,
    val priceInr: Int,
    val imageRes: Int,
    val isNew: Boolean = false
)

@Composable
fun BestSellersSection(
    cartItems: Map<Int, Int>,
    onAddToCart: (Int) -> Unit,
    onRemoveFromCart: (Int) -> Unit
) {
    val products = listOf(
        Product(1, "Berry Blast Protein Bar (6 Pack)", 4.8, 120, 399, R.drawable.bakery, true),
        Product(2, "Almond & Cranberry Trail Mix", 4.9, 85, 249, R.drawable.fruits),
        Product(3, "Healthy Cookies Pack Combo", 4.7, 64, 199, R.drawable.fastfood),
        Product(4, "Sparkling Drink Combo Pack", 4.6, 40, 159, R.drawable.drinks),
        Product(5, "Premium Snack Bar Box", 4.5, 33, 299, R.drawable.snacks),
        Product(6, "Healthy Seeds Mix (Premium)", 4.8, 90, 279, R.drawable.fruits),
        Product(7, "Choco Energy Bar (6 Pack)", 4.7, 55, 349, R.drawable.bakery, true),
        Product(8, "Nutaaj ke dudty Trail Mix Combo", 4.6, 22, 229, R.drawable.fruits),
        Product(9, "Protein Cookies Family Pack", 4.4, 18, 189, R.drawable.fastfood),
        Product(10, "Fresh Fruit Drink Pack", 4.3, 12, 149, R.drawable.drinks),
        Product(11, "Crunchy Snacks Variety Box", 4.5, 29, 199, R.drawable.snacks),
        Product(12, "Healthy Seeds Bowl Mix", 4.8, 77, 259, R.drawable.fruits)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Best Sellers", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("See All", color = Color(0xFFFF6D00), fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 0.dp, max = 10000.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            userScrollEnabled = false
        ) {
            items(products) { product ->
                ProductCard(
                    product = product,
                    quantity = cartItems[product.id] ?: 0,
                    onAdd = { onAddToCart(product.id) },
                    onRemove = { onRemoveFromCart(product.id) }
                )
            }
        }
    }
}

@Composable
private fun ProductCard(
    product: Product,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        shadowElevation = 2.dp,
        border = BorderStroke(1.dp, Color(0xFFEDEDED)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Box {
                // image
                Image(
                    painter = painterResource(product.imageRes),
                    contentDescription = product.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(14.dp))
                )

                // NEW tag
                if (product.isNew) {
                    Surface(
                        color = Color(0xFF34A853),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopStart)
                    ) {
                        Text(
                            "NEW",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier.height(40.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    text = product.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    lineHeight = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            // rating row
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("★", color = Color(0xFFF4B400))
                Spacer(modifier = Modifier.width(4.dp))
                Text("${product.rating}", fontSize = 12.sp, color = Color(0xFF666666))
                Spacer(modifier = Modifier.width(4.dp))
                Text("(${product.ratingCount})", fontSize = 12.sp, color = Color(0xFF999999))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "₹${product.priceInr}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF6D00)
                )

                if (quantity == 0) {
                    Surface(
                        color = Color(0xFFFF6D00),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.size(40.dp)
                    ) {
                        IconButton(
                            onClick = onAdd,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = Color.White
                            )
                        }
                    }
                } else {
                    Surface(
                        color = Color(0xFFFF6D00),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            IconButton(
                                onClick = onRemove,
                                modifier = Modifier.size(32.dp)
                            ) {
                                Text(
                                    "−",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Text(
                                text = quantity.toString(),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                            IconButton(
                                onClick = onAdd,
                                modifier = Modifier.size(32.dp)
                            ) {
                                Text(
                                    "+",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}