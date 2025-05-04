package com.edu.biblioteca_musica.features.home.album.domain

interface AlbumRepository {

    suspend fun getAlbums(): List<Album>
    suspend fun saveAlbums(albums: List<Album>)
    suspend fun deleteAlbums()
}