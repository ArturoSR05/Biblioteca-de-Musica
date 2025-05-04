package com.edu.biblioteca_musica.features.library.data.local.remote

import com.edu.biblioteca_musica.features.library.domain.Song

class SongApiRemoteDataSource(private val songService: SongService) {

    suspend fun getSongs(): List<Song> {
        val response = songService.getSongs()
        return if (response.isSuccessful) {
            response.body()!!.map{
                it.toModel()
            }
        } else {
            emptyList()
        }
    }
}