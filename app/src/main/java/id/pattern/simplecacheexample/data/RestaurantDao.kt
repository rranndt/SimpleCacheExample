package id.pattern.simplecacheexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurants")
    fun getAllRestaurants(): Flow<List<Restaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurant: List<Restaurant>)

    @Query("DELETE FROM restaurants")
    suspend fun deleteAllRestaurants()
}