package com.edu.biblioteca_musica.features.home.artist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.edu.biblioteca_musica.R
import com.edu.biblioteca_musica.features.home.artist.domain.Artist

class ArtistAdapter: ListAdapter<Artist, ArtistViewHolder>(ArtistDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_artist_item, parent,false)
        return ArtistViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}