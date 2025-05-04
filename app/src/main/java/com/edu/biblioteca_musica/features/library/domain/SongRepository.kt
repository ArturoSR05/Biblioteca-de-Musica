package com.edu.biblioteca_musica.features.library.domain

interface SongRepository {

    suspend fun getSongs(): List<Song>
}