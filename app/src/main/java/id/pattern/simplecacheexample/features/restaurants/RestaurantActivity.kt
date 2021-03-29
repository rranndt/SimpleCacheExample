package id.pattern.simplecacheexample.features.restaurants

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import id.pattern.simplecacheexample.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import id.pattern.simplecacheexample.databinding.ActivityRestaurantBinding

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private val viewModel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            rvRestaurant.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }

            viewModel.restaurants.observe(this@RestaurantActivity) { result ->
                restaurantAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                tvError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                tvError.text = result.error?.localizedMessage
            }
        }
    }
}