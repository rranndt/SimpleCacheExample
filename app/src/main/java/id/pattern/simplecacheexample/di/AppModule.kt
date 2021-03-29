package id.pattern.simplecacheexample.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.pattern.simplecacheexample.api.RestaurantApi
import id.pattern.simplecacheexample.data.RestaurantDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(RestaurantApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): RestaurantApi =
        retrofit.create(RestaurantApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): RestaurantDatabase {
        return Room.databaseBuilder(app, RestaurantDatabase::class.java, "restaurant_database")
            .build()
    }
}