package id.pattern.simplecacheexample.data

import androidx.room.withTransaction
import id.pattern.simplecacheexample.api.RestaurantApi
import id.pattern.simplecacheexample.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurant() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurants()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}