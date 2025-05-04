package com.edu.biblioteca_musica.app.di

import android.content.Context
import androidx.room.Room
import com.edu.biblioteca_musica.app.data.local.db.MusicLibraryDataBase
import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDataBase(context: Context): MusicLibraryDataBase{
        val db = Room.databaseBuilder(
            context,
            MusicLibraryDataBase::class.java,
            "music_library_db"
        )
        db.fallbackToDestructiveMigration()
        return db.build()
    }
}