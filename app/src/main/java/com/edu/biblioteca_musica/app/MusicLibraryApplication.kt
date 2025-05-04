package com.edu.biblioteca_musica.app

import android.app.Application
import com.edu.biblioteca_musica.app.di.AppModule
import com.edu.biblioteca_musica.app.di.LocalModule
import com.edu.biblioteca_musica.app.di.RemoteModule
import com.edu.biblioteca_musica.features.home.album.di.AlbumModule
import com.edu.biblioteca_musica.features.home.artist.di.ArtistModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.ksp.generated.module

class MusicLibraryApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MusicLibraryApplication)
            modules(
                LocalModule().module,
                RemoteModule().module,
                AppModule().module,
                ArtistModule().module,
                AlbumModule().module
            )
        }
    }
}