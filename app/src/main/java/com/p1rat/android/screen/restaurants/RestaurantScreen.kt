package com.p1rat.android.screen.restaurants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.p1rat.android.R
import com.p1rat.android.data.RemoteRestaurant

@Composable
fun RestaurantScreen(restaurantViewModel: RestaurantViewModel = viewModel()) {
    val viewState by restaurantViewModel.viewState.collectAsState()

    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        item { Text(text = stringResource(R.string.popular), fontSize = 40.sp)}
        items(viewState.popularRestaurants) { restaurant ->
            RestaurantImage(restaurant = restaurant)
        }
        item {Text(text = stringResource(R.string.nearest), fontSize = 40.sp)}
        items(viewState.nearestRestaurants) {
            restaurant -> 
            RestaurantImage(restaurant = restaurant)
        }
    }
}

@Composable
fun RestaurantImage(restaurant: RemoteRestaurant) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .border(BorderStroke(5.dp, SolidColor(Color.Transparent)))
            .shadow(3.dp)
            .padding(15.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = restaurant.image,
                contentDescription = restaurant.name,
                error = painterResource(id = R.drawable.logo),
                modifier = Modifier.size(100.dp)
            )
            Text(text = restaurant.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = restaurant.deliveryTime)
        }
    }
}