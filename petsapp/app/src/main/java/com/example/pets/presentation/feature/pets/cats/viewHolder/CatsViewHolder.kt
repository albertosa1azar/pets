package com.example.pets.presentation.feature.pets.cats.viewHolder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pets.R
import com.example.pets.databinding.ItemCatsBreedsBinding
import com.example.pets.domain.entity.CatBreed

class CatsViewHolder(itemView: View, private val onCatClick: (CatBreed) -> Unit,private val onFavoriteClick: (CatBreed) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    private val tvBreed = ItemCatsBreedsBinding.bind(itemView).tvBreed
    private val ivImage = ItemCatsBreedsBinding.bind(itemView).ivPetsPlaceholder
    private val ivFavorite = ItemCatsBreedsBinding.bind(itemView).ivFavorite

    fun bind(item: CatBreed) {

        tvBreed.text = item.name

        with(ivFavorite) {
            setImageDrawable(getFavoriteIcon(item))
            setOnClickListener {
                item.isFavorite = !item.isFavorite
                setImageDrawable(getFavoriteIcon(item))
                onFavoriteClick(item)
            }
        }

        Glide.with(itemView.context)
            .load(item.image?.url)
            .placeholder(R.drawable.ic_pets_placeholder)
            .into(ivImage)

        itemView.setOnClickListener {
            onCatClick(item)
        }
    }

    private fun getFavoriteIcon(catBreed: CatBreed) =
        ContextCompat.getDrawable(
            itemView.context,
            if (catBreed.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_rounded
        )
}