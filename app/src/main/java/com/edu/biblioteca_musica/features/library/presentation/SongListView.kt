package com.edu.biblioteca_musica.features.library.presentation

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edu.biblioteca_musica.R
import com.edu.biblioteca_musica.features.library.data.local.remote.toModel
import com.edu.biblioteca_musica.features.library.di.SongModule
import com.edu.biblioteca_musica.features.library.presentation.adapter.SongAdapter
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class SongListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val recyclerView: RecyclerView
    private val songAdapter = SongAdapter()
    private val songService = SongModule()

    init {
        LayoutInflater.from(context).inflate(R.layout.view_song_list, this, true)
        recyclerView = findViewById(R.id.recyclerViewSongs)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = songAdapter
    }

    fun fetchSongs(retrofit: Retrofit) {
        (context as? FragmentActivity)?.lifecycleScope?.launch {
            try {
                val response = songService.provideSongService(retrofit).getSongs()
                songAdapter.submitList(response.body()?.map { it.toModel() })
            } catch (e: Exception) {
                Log.e("SongListView", "Error al obtener canciones", e)
            }
        }
    }
}