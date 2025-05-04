package com.edu.biblioteca_musica.features.library.di

import com.edu.biblioteca_musica.app.data.local.db.MusicLibraryDataBase
import com.edu.biblioteca_musica.features.library.data.local.db.SongDao
import com.edu.biblioteca_musica.features.library.data.local.remote.SongService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class SongModule {

    @Single
    fun provideSongService(retrofit: Retrofit): SongService = retrofit.create(SongService::class.java)

    @Single
    fun provideSongDao(db: MusicLibraryDataBase): SongDao {
        return db.songDao()
    }


}