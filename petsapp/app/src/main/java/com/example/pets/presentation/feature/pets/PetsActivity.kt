package com.example.pets.presentation.feature.pets

import android.content.Intent
import android.os.Bundle
import com.example.pets.R
import com.example.pets.databinding.ActivityPetsBinding
import com.example.pets.presentation.base.BaseBottomNavigationActivity
import com.example.pets.presentation.feature.pets.cats.CatsHostActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PetsActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityPetsBinding

    override val currentTab: Int = R.id.pets_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPetsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        setUpPetActions()
    }

    private fun setUpPetActions() {
        binding.ivCats.setOnClickListener {
            val intent = Intent(this, CatsHostActivity::class.java)
            startActivity(intent)
        }

    }

    override fun getBottomNavigation(): BottomNavigationView =
        binding.bottomNavigation.bottomNavigation

}