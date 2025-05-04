package com.edu.biblioteca_musica.features.home.album.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edu.biblioteca_musica.R
import com.edu.biblioteca_musica.databinding.ViewAlbumItemBinding
import com.edu.biblioteca_musica.features.home.album.domain.Album

class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewAlbumItemBinding

    private val imageView: ImageView = view.findViewById(R.id.albumImageView)
    private val nameTextView: TextView = view.findViewById(R.id.albumTitle)

    fun bind(album: Album){
        binding = ViewAlbumItemBinding.bind(itemView)
        binding.apply {
            nameTextView.text = album.id
            nameTextView.text = album.title
            Glide.with(imageView.context).load(album.cover).into(imageView)
        }
    }
}