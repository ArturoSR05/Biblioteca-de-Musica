package com.edu.biblioteca_musica.features.home.album.data

import com.edu.biblioteca_musica.features.home.album.data.local.db.AlbumDbLocalDataSource
import com.edu.biblioteca_musica.features.home.album.data.remote.retrofit.AlbumApiRemoteDataSource
import com.edu.biblioteca_musica.features.home.album.domain.Album
import com.edu.biblioteca_musica.features.home.album.domain.AlbumRepository
import org.koin.core.annotation.Single

@Single
class AlbumDataRepository(
    private val localDataSource: AlbumDbLocalDataSource,
    private val remoteDataSource: AlbumApiRemoteDataSource,
): AlbumRepository {

    override suspend fun getAlbums(): List<Album> {
        val localAlbums = localDataSource.findAll()
        if (localAlbums.isEmpty()){
            val remoteAlbums = remoteDataSource.getAlbums()
            localDataSource.saveAll(remoteAlbums)
            return remoteAlbums
        }
        return localAlbums
    }

    override suspend fun saveAlbums(albums: List<Album>) {
        localDataSource.saveAll(albums)
    }

    override suspend fun deleteAlbums() {
        localDataSource.deleteAlbums()
    }
}