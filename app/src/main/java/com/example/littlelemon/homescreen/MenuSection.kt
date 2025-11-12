package com.example.littlelemon.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.littlelemon.data.MenuItem
import com.example.littlelemon.R


@Composable
fun MenuSection(
    menuItems: List<MenuItem>,
    onCatagorySelect: (String) -> Unit
) {
    val markazi = FontFamily(Font(R.font.markazi_text_regular))
    val karla = FontFamily(Font(R.font.karla_variablefont_wght))

    Column {
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "ORDER FOR DELIVERY!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp),
            fontFamily = karla
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val categories = listOf("Starters", "Mains", "Desserts", "Drinks")
            items(items = categories) { category ->
                Button(
                    onClick = { onCatagorySelect(category) },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEDEFEE)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = category,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = karla

                    )
                }
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp),
            thickness = 1.dp,
            color = Color.LightGray,

            )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            items(items = menuItems) { menuItem ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = menuItem.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = karla
                        )
                        Text(
                            text = menuItem.description,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontFamily = karla
                        )
                        Text(
                            text = "$${menuItem.price}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = karla

                            )
                    }
                    AsyncImage(
                        model = menuItem.image,
                        contentDescription = menuItem.title,
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuSectionPreview() {
    MenuSection(
        menuItems = listOf(
            MenuItem(1, "Greek Salad", "The famous greek salad...", 12.99, "", "starters"),
            MenuItem(2, "Bruschetta", "Our Bruschetta is made from...", 5.99, "", "starters")
        ),
        onCatagorySelect = {}
    )
}
