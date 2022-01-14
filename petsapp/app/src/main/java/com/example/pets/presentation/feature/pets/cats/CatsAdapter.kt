package com.example.pets.presentation.feature.pets.cats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pets.R
import com.example.pets.domain.entity.CatBreed
import com.example.pets.presentation.feature.pets.cats.viewHolder.CatsViewHolder

class CatsAdapter(
    private val list: List<CatBreed>,
    private val onCatClick: (CatBreed) -> Unit,
    private val onFavoriteClick: (CatBreed) -> Unit,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflateView(R.layout.item_cats_breeds, parent)
        return CatsViewHolder(view, onCatClick, onFavoriteClick)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        (viewHolder as CatsViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}