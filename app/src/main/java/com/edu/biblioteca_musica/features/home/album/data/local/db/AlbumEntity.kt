package com.edu.biblioteca_musica.features.home.album.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val ALBUM_TABLE = "albums"
const val ALBUM_ID = "id"

@Entity(tableName = ALBUM_TABLE)
data class AlbumEntity (
    @PrimaryKey @ColumnInfo(name = ALBUM_ID) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "cover") val cover: String
)