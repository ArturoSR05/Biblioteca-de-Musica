package com.edu.biblioteca_musica.features.library.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edu.biblioteca_musica.R
import com.edu.biblioteca_musica.databinding.ViewSongItemBinding
import com.edu.biblioteca_musica.features.library.domain.Song

class SongViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewSongItemBinding

    private val idTextView: TextView = view.findViewById(R.id.songId)
    private val titleTextView: TextView = view.findViewById(R.id.songTitle)

    fun bind(song: Song) {
        binding = ViewSongItemBinding.bind(view)
        binding.apply {
            idTextView.text = song.id
            titleTextView.text = song.title
        }
    }
}