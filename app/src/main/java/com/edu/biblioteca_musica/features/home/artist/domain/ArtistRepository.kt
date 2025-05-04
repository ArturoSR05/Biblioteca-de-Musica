package com.edu.biblioteca_musica.features.home.artist.domain

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>
    suspend fun saveArtists(artists: List<Artist>)
    suspend fun deleteArtists()

}