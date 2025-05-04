package com.edu.biblioteca_musica.features.library.data.local.db

import com.edu.biblioteca_musica.features.library.domain.Song

class SongDbLocalDataSource(private val songDao: SongDao) {

    suspend fun findAll(): List<Song> {
        val songs = songDao.getSongs()
        return if (songs.isEmpty()) {
            emptyList()
        } else(songs.map { it.toDomain() })
    }

    suspend fun saveAll(songs: List<Song>) {
        val devList = songs.map {
            it.toEntity()
        }
        songDao.insertSongs(*devList.toTypedArray())
    }

    suspend fun deleteSongs(){
        songDao.deleteAll()
    }
}