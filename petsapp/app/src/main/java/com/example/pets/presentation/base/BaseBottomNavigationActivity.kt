package com.example.pets.presentation.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pets.R
import com.example.pets.presentation.feature.favorites.FavoritesHostActivity
import com.example.pets.presentation.feature.my_pets.MyPetsActivity
import com.example.pets.presentation.feature.pets.PetsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigationActivity : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNavigationActions()
        selectCurrentTab()
    }

    private fun setUpBottomNavigationActions() {
        getBottomNavigation().setOnItemSelectedListener {
            if (it.itemId != this.currentTab) when (it.itemId) {
                R.id.pets_menu -> {
                    val intent = Intent(this, PetsActivity::class.java)
                    startActivity(intent)
                }
                R.id.favorites_menu -> {
                    val intent = Intent(this, FavoritesHostActivity::class.java)
                    startActivity(intent)
                }
                R.id.my_pets_menu -> {
                    val intent = Intent(this, MyPetsActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}