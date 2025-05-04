package com.edu.biblioteca_musica.features.home.artist.data

import com.edu.biblioteca_musica.features.home.artist.data.local.db.ArtistDbLocalDataSource
import com.edu.biblioteca_musica.features.home.artist.data.remote.retrofit.ArtistApiRemoteDataSource
import com.edu.biblioteca_musica.features.home.artist.domain.Artist
import com.edu.biblioteca_musica.features.home.artist.domain.ArtistRepository
import org.koin.core.annotation.Single

@Single
class ArtistDataRepository(
    private val localDataSource: ArtistDbLocalDataSource,
    private val remoteDataSource: ArtistApiRemoteDataSource,
): ArtistRepository {

    override suspend fun getArtists(): List<Artist> {
        val localArtists = localDataSource.findAll()
        if (localArtists.isEmpty()){
            val remoteArtists = remoteDataSource.getArtists()
            localDataSource.saveAll(remoteArtists)
            return remoteArtists
        }
        return localArtists
    }

    override suspend fun saveArtists(artists: List<Artist>) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArtists() {
        TODO("Not yet implemented")
    }
}