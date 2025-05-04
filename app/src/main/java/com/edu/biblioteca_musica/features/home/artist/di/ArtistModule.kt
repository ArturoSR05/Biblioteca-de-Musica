package com.edu.biblioteca_musica.features.home.artist.di

import com.edu.biblioteca_musica.app.data.local.db.MusicLibraryDataBase
import com.edu.biblioteca_musica.features.home.album.data.local.db.AlbumDao
import com.edu.biblioteca_musica.features.home.album.data.remote.retrofit.AlbumService
import com.edu.biblioteca_musica.features.home.artist.data.local.db.ArtistDao
import com.edu.biblioteca_musica.features.home.artist.data.remote.retrofit.ArtistService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class ArtistModule {

    @Single
    fun provideArtistService(retrofit: Retrofit): ArtistService = retrofit.create(ArtistService::class.java)

    @Single
    fun provideArtistDao(db: MusicLibraryDataBase): ArtistDao {
        return db.artistDao()
    }
}