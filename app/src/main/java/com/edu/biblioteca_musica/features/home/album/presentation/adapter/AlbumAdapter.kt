package com.edu.biblioteca_musica.features.home.album.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.edu.biblioteca_musica.features.home.album.domain.Album
import androidx.recyclerview.widget.ListAdapter
import com.edu.biblioteca_musica.R

class AlbumAdapter: ListAdapter<Album, AlbumViewHolder>(AlbumDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_album_item, parent,false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}