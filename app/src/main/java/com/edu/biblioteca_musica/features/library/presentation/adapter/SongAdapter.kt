package com.edu.biblioteca_musica.features.library.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.edu.biblioteca_musica.R
import com.edu.biblioteca_musica.features.library.domain.Song

class SongAdapter: ListAdapter<Song, SongViewHolder>(SongDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_song_item, parent,false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}