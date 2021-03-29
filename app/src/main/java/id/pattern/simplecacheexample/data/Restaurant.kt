package id.pattern.simplecacheexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@Entity(tableName = "restaurants")
data class Restaurant(

    @PrimaryKey
    val name: String,

    val type: String,

    val logo: String,

    val address: String
)