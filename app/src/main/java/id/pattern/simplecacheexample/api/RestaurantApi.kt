package id.pattern.simplecacheexample.api

import id.pattern.simplecacheexample.data.Restaurant
import retrofit2.http.GET

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET
        ("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}