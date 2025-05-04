package com.edu.biblioteca_musica.features.home.artist.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edu.biblioteca_musica.R
import com.edu.biblioteca_musica.databinding.ViewArtistItemBinding
import com.edu.biblioteca_musica.features.home.artist.domain.Artist

class ArtistViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewArtistItemBinding

    private val imageView: ImageView = view.findViewById(R.id.imageArtist)
    private val nameTextView: TextView = view.findViewById(R.id.artistName)

    fun bind(artist: Artist) {
        binding = ViewArtistItemBinding.bind(view)
        binding.apply {
            nameTextView.text = artist.name
            Glide.with(imageView.context).load(artist.picture).into(imageView)
        }
    }
}