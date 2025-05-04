package com.edu.biblioteca_musica.features.home.artist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.edu.biblioteca_musica.features.home.artist.domain.Artist

class ArtistDiffUtil: DiffUtil.ItemCallback<Artist>() {

    override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean =
        oldItem == newItem

}