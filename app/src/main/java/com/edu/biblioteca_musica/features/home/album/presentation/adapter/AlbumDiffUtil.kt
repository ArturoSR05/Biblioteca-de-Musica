package com.edu.biblioteca_musica.features.home.album.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.edu.biblioteca_musica.features.home.album.domain.Album

class AlbumDiffUtil: DiffUtil.ItemCallback<Album>() {

    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean =
        oldItem == newItem

}