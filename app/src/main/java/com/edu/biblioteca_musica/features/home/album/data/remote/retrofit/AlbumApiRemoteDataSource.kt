package com.edu.biblioteca_musica.features.home.album.data.remote.retrofit

import com.edu.biblioteca_musica.features.home.album.domain.Album
import org.koin.core.annotation.Single

@Single
class AlbumApiRemoteDataSource(private val albumService: AlbumService) {

    suspend fun getAlbums(): List<Album> {
        val response = albumService.getAlbums()

        return if (response.isSuccessful) {
            val albumsList = response.body()?.albums?.map { it.toModel() } ?: emptyList()
            albumsList.shuffled()
        } else {
            emptyList()
        }
    }
}
