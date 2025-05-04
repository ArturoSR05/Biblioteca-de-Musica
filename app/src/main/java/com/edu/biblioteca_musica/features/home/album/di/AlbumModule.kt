package com.edu.biblioteca_musica.features.home.album.di

import com.edu.biblioteca_musica.app.data.local.db.MusicLibraryDataBase
import com.edu.biblioteca_musica.features.home.album.data.local.db.AlbumDao
import com.edu.biblioteca_musica.features.home.album.data.remote.retrofit.AlbumService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class AlbumModule {

    @Single
    fun provideAlbumService(retrofit: Retrofit): AlbumService = retrofit.create(AlbumService::class.java)

    @Single
    fun provideAlbumDao(db: MusicLibraryDataBase): AlbumDao {
        return db.albumDao()
    }

}