package com.p1rat.android.screen.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.p1rat.android.data.catalog.RemoteRestaurant
import com.p1rat.android.data.catalog.RestaurantRepository
import com.p1rat.android.data.catalog.mapToNearestRestaurantEntity
import com.p1rat.android.data.catalog.mapToPopularRestaurantEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
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

    private val _viewState: MutableLiveData<RestaurantState> = MutableLiveData(RestaurantState())
    val viewState: LiveData<RestaurantState> = _viewState

    init {
        getRestaurants()
    }

    private fun getRestaurants() {
        viewModelScope.launch(Dispatchers.Default) {
            restaurantRepository.fetchCatalog()
                .collectLatest { response ->
                    _viewState.postValue(
                        _viewState.value?.copy(
                            nearestRestaurants = response.nearest,
                            popularRestaurants = response.popular
                        )
                    )
                }
        }
    }
}