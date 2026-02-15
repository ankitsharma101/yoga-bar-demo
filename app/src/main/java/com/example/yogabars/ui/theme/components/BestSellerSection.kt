package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yogabars.R

data class Product(
    val id: Int,
    val title: String,
    val subtitle: String,
    val price: Int,
    val originalPrice: Int,
    val imageRes: Int,
    val badgeText: String? = null,
    val badgeColor: Color = Color(0xFFE91E63)
)

@Composable
fun BestSellerSection(
    cartItems: Map<Int, Int>,
    onAddToCart: (Int) -> Unit,
    onRemoveFromCart: (Int) -> Unit
) {
    val products = listOf(
        Product(
            id = 1,
            title = "Multigrain Energy Bar - Dark Chocolate",
            subtitle = "Pack of 10 · 380g",
            price = 450,
            originalPrice = 500,
            imageRes = R.drawable.bakery,
            badgeText = "SAVE 10%",
            badgeColor = Color(0xFFE91E63)
        ),
        Product(
            id = 2,
            title = "High Protein Oats - Dark Chocolate",
            subtitle = "Instant Mix · 400g",
            price = 299,
            originalPrice = 350,
            imageRes = R.drawable.snacks,
            badgeText = "BESTSELLER",
            badgeColor = Color(0xFF2E7D32)
        )
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
            Text("See MORE", color = Color(0xFFE91E63), fontWeight = FontWeight.SemiBold)
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
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF6EBDC))
            ) {

                Image(
                    painter = painterResource(product.imageRes),
                    contentDescription = product.title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )

                product.badgeText?.let {
                    Surface(
                        color = product.badgeColor,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = it,
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = product.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.subtitle,
                fontSize = 13.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "₹${product.price}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE91E63)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = "₹${product.originalPrice}",
                            fontSize = 13.sp,
                            color = Color.Gray,
                            style = LocalTextStyle.current.copy(
                                textDecoration = TextDecoration.LineThrough
                            )
                        )
                    }
                }

                if (quantity == 0) {

                    Button(
                        onClick = onAdd,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE91E63)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Text("ADD", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                } else {

                    Surface(
                        color = Color(0xFFE91E63),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.height(36.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "−",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(horizontal = 6.dp)
                                    .clickable { onRemove() }
                            )

                            Text(
                                text = quantity.toString(),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )

                            Text(
                                text = "+",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(horizontal = 6.dp)
                                    .clickable { onAdd() }
                            )
                        }
                    }
                }
            }
        }
    }
}
