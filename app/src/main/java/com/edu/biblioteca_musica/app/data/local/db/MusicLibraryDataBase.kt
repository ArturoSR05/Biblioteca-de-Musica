package com.edu.biblioteca_musica.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.edu.biblioteca_musica.BuildConfig
import com.edu.biblioteca_musica.features.home.album.data.local.db.AlbumDao
import com.edu.biblioteca_musica.features.home.album.data.local.db.AlbumEntity
import com.edu.biblioteca_musica.features.home.artist.data.local.db.ArtistDao
import com.edu.biblioteca_musica.features.home.artist.data.local.db.ArtistEntity

@Database(entities = [AlbumEntity::class, ArtistEntity::class], version = BuildConfig.VERSION_CODE, exportSchema = false)

abstract class MusicLibraryDataBase: RoomDatabase() {

    abstract fun albumDao(): AlbumDao

    abstract fun artistDao(): ArtistDao
}