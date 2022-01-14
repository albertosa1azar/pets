package com.example.pets.presentation.feature.favorites

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.pets.R
import com.example.pets.databinding.ActivityCatsHostBinding
import com.example.pets.databinding.ActivityFavoritesHostBinding
import com.example.pets.presentation.base.BaseBottomNavigationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val VIEW_CONTENT = 0
private const val VIEW_LOADING = 1
private const val VIEW_ERROR = 2

class FavoritesHostActivity : BaseBottomNavigationActivity() {

    private val viewModel: FavoritesViewModel by viewModel()

    private lateinit var binding: ActivityFavoritesHostBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostContainer.id) as NavHostFragment)
            .findNavController()
    }

    override val currentTab: Int = R.id.favorites_menu

    override fun getBottomNavigation(): BottomNavigationView =
        binding.bottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
        setupNavController()
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val title = when (destination.id) {
                R.id.fragment_cats -> getString(R.string.txt_favorites)
                else -> getString(R.string.txt_details)
            }
            supportActionBar?.title = title
        }
    }

    private fun setUpViewModel() {
        viewModel.loading.observe(this) { isLoading ->
            binding.vpFavorites.displayedChild = if (isLoading) VIEW_LOADING else VIEW_CONTENT
        }

        viewModel.error.observe(this) { hasError ->
            binding.vpFavorites.displayedChild = if (hasError) VIEW_ERROR else VIEW_CONTENT
        }
    }

}