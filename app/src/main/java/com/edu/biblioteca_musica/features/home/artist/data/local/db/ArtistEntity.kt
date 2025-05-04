package com.edu.biblioteca_musica.features.home.artist.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val ARTIST_TABLE = "artists"
const val ARTIST_ID = "id"

@Entity(tableName = ARTIST_TABLE)
data class ArtistEntity (
    @PrimaryKey @ColumnInfo(name = ARTIST_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "picture") val picture: String
)