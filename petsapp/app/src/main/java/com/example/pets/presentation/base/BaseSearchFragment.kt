package com.example.pets.presentation.base

import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.pets.R
import com.example.pets.domain.entity.CatBreed

const val ID = "ID"
const val IS_FAVORITE = "IS_FAVORITE"

abstract class BaseSearchFragment : Fragment() {

    abstract val itemList: List<CatBreed>

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchView = menu.findItem(R.id.menu_search).actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query)
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                filterList(query)
                return true
            }
        })
    }

    private fun filterList(query: String?) {
        val filteredList = itemList.filter {
            if (query != null) {
                it.name.lowercase().contains(query.lowercase())
            } else true
        }

        setUpCatsRecyclerView(filteredList)
    }

    abstract fun setUpCatsRecyclerView(filteredList: List<CatBreed>)
}