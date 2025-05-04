package com.edu.biblioteca_musica.features.home.artist.data.local.db

import com.edu.biblioteca_musica.features.home.artist.domain.Artist
import org.koin.core.annotation.Single

@Single
class ArtistDbLocalDataSource(private val artistDao: ArtistDao) {

    suspend fun findAll(): List<Artist> {
        val artists = artistDao.getArtists()
        return if (artists.isEmpty()) {
            emptyList()
        } else (artists.map { it.toDomain() })
    }

    suspend fun saveAll(artists: List<Artist>) {
        val artistList = artists.map {
            it.toEntity()
        }
        artistDao.insertArtists(*artistList.toTypedArray())
    }
}