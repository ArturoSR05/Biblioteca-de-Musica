package com.edu.biblioteca_musica.features.home.artist.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArtistDao {

    @Query("SELECT * FROM $ARTIST_TABLE")
    suspend fun getArtists(): List<ArtistEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtists(vararg artists: ArtistEntity)

    @Query("DELETE FROM $ARTIST_TABLE")
    suspend fun deleteAll()
}