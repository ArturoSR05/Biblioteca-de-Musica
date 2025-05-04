package com.edu.biblioteca_musica.features.library.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val SONG_TABLE = "songs"
const val SONG_ID = "id"

@Entity(tableName = SONG_TABLE)
data class SongEntity (
    @PrimaryKey @ColumnInfo(name = SONG_ID) val id: String,
    @ColumnInfo(name = "title") val title: String
)