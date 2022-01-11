package com.example.pets.presentation.feature.anyway

import android.content.Intent
import android.os.Bundle
import com.example.pets.R
import com.example.pets.databinding.ActivityAnywayBinding
import com.example.pets.presentation.base.BaseBottomNavigationActivity
import com.example.pets.presentation.feature.pets.PetsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AnywayActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityAnywayBinding

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAnywayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        setUpAnywayActions()
    }

    private fun setUpAnywayActions() {
        binding.tvTitle.setOnClickListener {
            val intent = Intent(this, PetsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun getBottomNavigation(): BottomNavigationView = binding.bottomNavigation.bottomNavigation

}