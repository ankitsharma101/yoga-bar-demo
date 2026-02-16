package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Product(
    val id: Int,
    val title: String,
    val subtitle: String,
    val price: Int,
    val originalPrice: Int,
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
                1,
                "High Protein Oats - Berry Burst",
                "Instant Mix · 400g",
                299,
                350,
                "BESTSELLER",
                Color(0xFF2D2D2D)
            ),

    Product(
        2,
        "Stuffed Baked Apple - Spiced Oat",
        "Freshly Baked · 1 Unit",
        149,
        199,
        "SEASONAL",
        Color(0xFFE67E22)
    ),

    Product(
        3,
        "PB & Banana Protein Pop",
        "Frozen Treat · 110ml",
        89,
        120
    ),

    Product(
        4,
        "Gourmet Butter Apple Toast",
        "Artisan Sourdough · 1 Unit",
        199,
        250
    ),

    Product(
        5,
        "Yogurt & Berry Granola Tarts",
        "Pack of 4 · 200g",
        349,
        450
    ),

    Product(
        6,
        "Nut Butter Chickpea Protein Ball",
        "Energy Bite · 50g",
        59,
        75
    ),

    Product(
        7,
        "High Protein Muesli - Seeds & Nuts",
        "Whole Grain · 850g",
        549,
        650
    ),

    Product(
        8,
        "Nuts & Seeds Protein Bar",
        "Energy Bar · 60g",
        99,
        130
    ),

    Product(
        9,
        "Ultra-Lean Whey Shake - Blue Ice",
        "Ready to Drink · 330ml",
        179,
        220
    ),

    Product(
        10,
        "PowerUp Protein Bar - Dark Choco",
        "Energy Bar · 65g",
        120,
        150
    ),

    Product(
        11,
        "Creamy Greek Yogurt - Roasted Almond",
        "High Protein · 200g",
        129,
        160
    ),

    Product(
        12,
        "Tropical Chia Seed Pudding",
        "Breakfast Jar · 250g",
        189,
        240
    ))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {

        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "BEST SELLERS",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF0B3D2E)
            )

            Text(
                text = "SEE MORE",
                color = Color(0xFFE91E63),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        products.chunked(2).forEach { rowItems ->

            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

                rowItems.forEach { product ->
                    ProductCard(
                        product = product,
                        quantity = cartItems[product.id] ?: 0,
                        onAdd = { onAddToCart(product.id) },
                        onRemove = { onRemoveFromCart(product.id) },
                        modifier = Modifier.weight(1f)
                    )
                }

                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

@Composable
fun ProductCard(
    product: Product,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF5E9DA)),
                contentAlignment = Alignment.TopStart
            ) {

                val context = LocalContext.current
                val imageRes = context.resources.getIdentifier(
                    "product_${product.id}",
                    "drawable",
                    context.packageName
                )

                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = product.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                product.badgeText?.let {
                    Surface(
                        color = product.badgeColor,
                        shape = RoundedCornerShape(50),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = it,
                            color = Color.White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(
                                horizontal = 10.dp,
                                vertical = 4.dp
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = product.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1C1C1C),
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.subtitle,
                fontSize = 11.sp,
                color = Color(0xFF9E9E9E)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Price
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
                        fontSize = 11.sp,
                        color = Color(0xFFBDBDBD),
                        textDecoration = TextDecoration.LineThrough
                    )
                }

                // ---- BUTTON AREA ----
                val buttonHeight = 34.dp
                val buttonMinWidth = 90.dp

                if (quantity == 0) {

                    Button(
                        onClick = onAdd,
                        modifier = Modifier
                            .height(buttonHeight)
                            .defaultMinSize(minWidth = buttonMinWidth),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE91E63)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp)
                    ) {
                        Text(
                            "ADD",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }

                } else {

                    Row(
                        modifier = Modifier
                            .height(buttonHeight)
                            .defaultMinSize(minWidth = buttonMinWidth)
                            .background(
                                Color(0xFFE91E63),
                                RoundedCornerShape(12.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Text(
                            "-",
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .clickable { onRemove() }
                                .padding(horizontal = 8.dp)
                        )

                        Text(
                            text = quantity.toString(),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "+",
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .clickable { onAdd() }
                                .padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}