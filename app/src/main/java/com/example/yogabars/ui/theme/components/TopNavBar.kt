package com.example.yogabars.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shop
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
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.ColorFilter
import com.example.yogabars.R
import androidx.compose.ui.zIndex
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

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
    )

    {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(top = 8.dp),
            shape = RoundedCornerShape(0.dp),
            color = Color.White,
            shadowElevation = 0.dp
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                NavItem("HOME", Icons.Default.Home, selectedItem == 0) {
                    onItemSelected(0)
                }

                NavItem("SHOP", Icons.Default.Shop, selectedItem == 1) {
                    onItemSelected(1)
                }

                Spacer(modifier = Modifier.width(50.dp))

                NavItem("OFFERS", Icons.Default.LocalOffer, selectedItem == 3) {
                    onItemSelected(3)
                }

                NavItem("PROFILE", Icons.Default.Person, selectedItem == 4) {
                    onItemSelected(4)
                }
            }
        }

        Text(
            text = "WELLNESS",
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = -30.dp)
        )

        Surface(
            modifier = Modifier
                .size(55.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 25.dp),
            shape = CircleShape,
            color = Color.White,
            shadowElevation = 25.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier
                        .size(45.dp)
                        .clickable { onItemSelected(2) },
                    shape = CircleShape,
                    color = Color(0xFFE91E63),
                    shadowElevation = 10.dp
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.wellness_icon),
                            contentDescription = "Wellness",
                            modifier = Modifier.size(100.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }
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
            fontWeight = FontWeight.SemiBold,
            color = if (selected) Color(0xFFE91E63) else Color.Gray
        )
    }
}
