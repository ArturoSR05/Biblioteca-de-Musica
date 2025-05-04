package com.edu.biblioteca_musica.features.home.album.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDao {

    @Query("SELECT * FROM $ALBUM_TABLE")
    suspend fun getAlbums(): List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbums(vararg albums: AlbumEntity)

    @Query("DELETE FROM $ALBUM_TABLE")
    suspend fun deleteAll()

}