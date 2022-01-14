package com.example.pets.presentation.feature.pets.cats.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pets.databinding.FragmentCatsDetailBinding

const val EXTRA_CAT_IMAGE = "EXTRA_CAT_IMAGE"
const val EXTRA_CAT_DESCRIPTION = "EXTRA_CAT_DESCRIPTION"
const val EXTRA_CAT_TEMPERAMENT = "EXTRA_CAT_TEMPERAMENT"
const val EXTRA_CAT_COUNTRY_CODE = "EXTRA_CAT_COUNTRY_CODE"
const val EXTRA_CAT_ORIGIN = "EXTRA_CAT_ORIGIN"

class CatsDetailFragment : Fragment() {

    private lateinit var binding: FragmentCatsDetailBinding

    private val catImage by lazy {
        arguments?.getString(EXTRA_CAT_IMAGE)
    }
    private val catDescription by lazy {
        arguments?.getString(EXTRA_CAT_DESCRIPTION)
    }
    private val catTemperament by lazy {
        arguments?.getString(EXTRA_CAT_TEMPERAMENT)
    }
    private val catCountryCode by lazy {
        arguments?.getString(EXTRA_CAT_COUNTRY_CODE)
    }
    private val catOrigin by lazy {
        arguments?.getString(EXTRA_CAT_ORIGIN)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatsDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCatDescription.text = catDescription.toString()
        binding.tvCatTemperament.text = catTemperament.toString()
        binding.tvCatCountryCode.text = catCountryCode.toString()
        binding.tvCatOrigin.text = catOrigin.toString()

        Glide.with(view.context)
            .load(catImage)
            .into(binding.ivCatsImage)
    }
}
