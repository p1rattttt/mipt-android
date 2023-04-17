package com.p1rat.android.screen.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.p1rat.android.data.RemoteRestaurant
import com.p1rat.android.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RestaurantState(
    val nearestRestaurants: List<RemoteRestaurant> = emptyList(),
    val popularRestaurants: List<RemoteRestaurant> = emptyList()
)


@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepository,
) :
    ViewModel() {

    private val _viewState: MutableStateFlow<RestaurantState> = MutableStateFlow(RestaurantState())
    val viewState: StateFlow<RestaurantState> = _viewState

    init {
        getRestaurants()
    }

    private fun getRestaurants() {
        viewModelScope.launch(Dispatchers.Default) {
            val response = restaurantRepository.fetchCatalog()
            _viewState.value = _viewState.value.copy(
                nearestRestaurants = response.nearest,
                popularRestaurants = response.popular
            )
        }
    }
}