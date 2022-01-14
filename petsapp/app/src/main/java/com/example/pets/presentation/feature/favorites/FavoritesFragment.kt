package com.example.pets.presentation.feature.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pets.R
import com.example.pets.data.database.entity.CatBreedEntity
import com.example.pets.data.database.mapper.toCatBreed
import com.example.pets.data.database.mapper.toEntity
import com.example.pets.databinding.FragmentFavoritesBinding
import com.example.pets.domain.entity.CatBreed
import com.example.pets.presentation.base.BaseSearchFragment
import com.example.pets.presentation.feature.pets.cats.detail.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoritesFragment : BaseSearchFragment() {

    private lateinit var binding: FragmentFavoritesBinding

    private val viewModel: FavoritesViewModel by sharedViewModel()

    override lateinit var itemList: List<CatBreed>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.cats.observe(viewLifecycleOwner) { list ->
            val breedList = list.map { it.toCatBreed() }
            itemList = breedList
            setUpCatsRecyclerView(breedList)
        }
        viewModel.fetchLocalCats()
    }

    override fun setUpCatsRecyclerView(filteredList: List<CatBreed>) {
        val list = filteredList.map { it.toEntity() }

        binding.rvFavorites.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = FavoritesAdapter(
                list,
                onCatClick = {
                    navigateToCatsDetail(it)
                },
                onFavoriteClick = {
                    viewModel.setFavorite(it)
                },
            )
        }
    }

    private fun navigateToCatsDetail(catBreedEntity: CatBreedEntity) {
        findNavController().navigate(
            R.id.cats_detail_fragment,
            bundleOf(
                Pair(EXTRA_CAT_IMAGE, catBreedEntity.image),
                Pair(EXTRA_CAT_DESCRIPTION, catBreedEntity.description),
                Pair(EXTRA_CAT_TEMPERAMENT, catBreedEntity.temperament),
                Pair(EXTRA_CAT_COUNTRY_CODE, catBreedEntity.country_code),
                Pair(EXTRA_CAT_ORIGIN, catBreedEntity.origin),
            )
        )
    }
}