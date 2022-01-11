package com.example.pets.presentation.feature.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pets.databinding.FragmentPetsBinding

class PetsFragment: Fragment() {

    private lateinit var binding: FragmentPetsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPetsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
    }

    private fun setUpCoffeeRecyclerView() {
    }

    private fun navigateToCoffeeDetail(id: Int) {
    }
}