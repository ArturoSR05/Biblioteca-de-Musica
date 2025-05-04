package com.edu.biblioteca_musica.features.home.album.data.local.db

import com.edu.biblioteca_musica.features.home.album.domain.Album
import org.koin.core.annotation.Single

@Single
class AlbumDbLocalDataSource(private val albumDao: AlbumDao) {

    suspend fun findAll(): List<Album> {
        val albums = albumDao.getAlbums()
        return if (albums.isEmpty()) {
            emptyList()
        } else(albums.map { it.toDomain() })
    }

    suspend fun saveAll(albums: List<Album>) {
        val devList = albums.map {
            it.toEntity()
        }
        albumDao.insertAlbums(*devList.toTypedArray())
    }

    suspend fun deleteAlbums(){
        albumDao.deleteAll()
    }
}