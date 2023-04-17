package com.p1rat.android.screen.restaurants.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.p1rat.android.R
import java.net.URLEncoder

@Composable
fun DetailScreen(name: String, image: String, deliveryTime: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = image,
                contentDescription = name,
                error = painterResource(id = R.drawable.logo),
                modifier = Modifier
                    .size(300.dp)
            )
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 50.sp)
            Text(text = deliveryTime, fontWeight = FontWeight.Bold, fontSize = 50.sp)
        }
    }
}

