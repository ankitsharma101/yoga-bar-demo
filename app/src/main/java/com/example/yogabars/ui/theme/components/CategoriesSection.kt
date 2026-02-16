package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CategoriesSection() {

    val categories = listOf(
        "Protein Bars" to Icons.Default.FitnessCenter,
        "Muesli" to Icons.Default.BreakfastDining,
        "Peanut" to Icons.Default.Eco,
        "Gluten Free" to Icons.Default.NoFood,
        "Vegan" to Icons.Default.Spa
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "CATEGORIES",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.sp,
                color = Color(0xFF0B3D2E)

            )


            Text(
                text = "VIEW ALL",
                color = Color(0xFFE91E63),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { (title, icon) ->
                CategoryItem(title, icon)
            }
        }
    }
}

@Composable
fun CategoryItem(title: String, icon: ImageVector) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(90.dp)
    ) {

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            shadowElevation = 4.dp,
            modifier = Modifier.size(72.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = Color(0xFFE91E63),
                    modifier = Modifier.size(35.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title.uppercase(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp,
            color = Color(0xFF0B3D2E),
            maxLines = 1
        )

    }
}
