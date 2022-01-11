package com.example.pets.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class  BaseBottomNavigationActivity : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0 ,0)
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
            if(it.itemId != this.currentTab) when (it.itemId) {
                //TODO("Not yet implemented")
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun  selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}