package com.p1rat.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Logo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "our logo",
            modifier = Modifier
                .size(150.dp)
        )
        Text(
            "FoodNinja",
            fontStyle = FontStyle.Italic,
            fontSize = 40.sp,
            color = Color(0xFF53E88B)
        )
        Text(
            "Deliever Favorite Food",
            fontSize = 15.sp,
            color = Color(0xFF09051C)
        )
    }
}