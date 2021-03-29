package id.pattern.simplecacheexample.features.restaurants

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import id.pattern.simplecacheexample.api.RestaurantApi
import id.pattern.simplecacheexample.data.Restaurant
import id.pattern.simplecacheexample.data.RestaurantRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurant().asLiveData()

   /* private val restaurantLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantLiveData

    init {
        viewModelScope.launch {
            val restaurant = api.getRestaurants()
            delay(2000)
            restaurantLiveData.value = restaurant
        }
    }*/
}