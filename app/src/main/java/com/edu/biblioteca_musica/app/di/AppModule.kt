package com.edu.biblioteca_musica.app.di

import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.edu.biblioteca_musica")
class AppModule {

    @Single
    fun provideGson() = Gson()
}