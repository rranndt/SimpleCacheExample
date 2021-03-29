package id.pattern.simplecacheexample.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}