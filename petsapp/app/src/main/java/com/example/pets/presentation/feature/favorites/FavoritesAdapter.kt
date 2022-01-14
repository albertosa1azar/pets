package com.example.pets.presentation.feature.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pets.R
import com.example.pets.data.database.entity.CatBreedEntity
import com.example.pets.presentation.feature.favorites.viewHolder.FavoritesViewHolder
import com.example.pets.presentation.feature.pets.cats.viewHolder.CatsViewHolder

class FavoritesAdapter(
    private val list: List<CatBreedEntity>,
    private val onCatClick: (CatBreedEntity) -> Unit,
    private val onFavoriteClick: (CatBreedEntity) -> Unit,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflateView(R.layout.item_cats_breeds, parent)
        return FavoritesViewHolder(view, onCatClick, onFavoriteClick)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        (viewHolder as FavoritesViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}