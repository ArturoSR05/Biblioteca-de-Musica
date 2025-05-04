package com.edu.biblioteca_musica.features.library.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDao {

    @Query("SELECT * FROM $SONG_TABLE")
    suspend fun getSongs(): List<SongEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(vararg songs: SongEntity)

    @Query("DELETE FROM $SONG_TABLE")
    suspend fun deleteAll()
}