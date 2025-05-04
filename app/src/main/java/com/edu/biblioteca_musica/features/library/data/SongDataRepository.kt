package com.edu.biblioteca_musica.features.library.data

import com.edu.biblioteca_musica.features.library.data.local.db.SongDbLocalDataSource
import com.edu.biblioteca_musica.features.library.data.local.remote.SongApiRemoteDataSource
import com.edu.biblioteca_musica.features.library.domain.Song
import com.edu.biblioteca_musica.features.library.domain.SongRepository

class SongDataRepository(
    private val localDataSource: SongDbLocalDataSource,
    private val remoteDataSource: SongApiRemoteDataSource
): SongRepository {

    override suspend fun getSongs(): List<Song> {
        val localSongs = localDataSource.findAll()
        if (localSongs.isEmpty()){
            val remoteAlbums = remoteDataSource.getSongs()
            localDataSource.saveAll(remoteAlbums)
            return remoteAlbums
        }
        return localSongs
    }
}