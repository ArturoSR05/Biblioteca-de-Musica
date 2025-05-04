package com.edu.biblioteca_musica.features.home.artist.data.remote.retrofit

import com.edu.biblioteca_musica.features.home.artist.domain.Artist
import org.koin.core.annotation.Single

@Single
class ArtistApiRemoteDataSource(private val artistService: ArtistService) {

    suspend fun getArtists(): List<Artist> {
        val response = artistService.getArtists()
        return if (response.isSuccessful) {
            response.body()?.data?.map {
                it.toModel()
            } ?: emptyList()
        } else {
            emptyList()
        }
    }
}