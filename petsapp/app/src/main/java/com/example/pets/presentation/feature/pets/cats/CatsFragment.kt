package com.example.pets.presentation.feature.pets.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pets.R
import com.example.pets.databinding.FragmentCatsBinding
import com.example.pets.domain.entity.CatBreed
import com.example.pets.presentation.base.BaseSearchFragment
import com.example.pets.presentation.feature.pets.cats.detail.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CatsFragment : BaseSearchFragment() {

    private lateinit var binding: FragmentCatsBinding

    private val viewModel: CatsViewModel by sharedViewModel()

    override lateinit var itemList: List<CatBreed>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatsBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.cats.observe(viewLifecycleOwner) { list ->
            itemList = list
            setUpCatsRecyclerView(list)
        }
        viewModel.fetchCats()
    }

    override fun setUpCatsRecyclerView(list: List<CatBreed>) {
        binding.rvCats.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = CatsAdapter(
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

    private fun navigateToCatsDetail(catBreed: CatBreed) {
        findNavController().navigate(
            R.id.cats_detail_fragment,
            bundleOf(
                Pair(EXTRA_CAT_IMAGE, catBreed.imageUrl),
                Pair(EXTRA_CAT_DESCRIPTION, catBreed.description),
                Pair(EXTRA_CAT_TEMPERAMENT, catBreed.temperament),
                Pair(EXTRA_CAT_COUNTRY_CODE, catBreed.country_code),
                Pair(EXTRA_CAT_ORIGIN, catBreed.origin),
            )
        )
    }
}