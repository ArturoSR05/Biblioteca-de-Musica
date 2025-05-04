package com.edu.biblioteca_musica.features.library.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.edu.biblioteca_musica.features.library.domain.Song

class SongDiffUtil: DiffUtil.ItemCallback<Song>() {

    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem == newItem
    }
}