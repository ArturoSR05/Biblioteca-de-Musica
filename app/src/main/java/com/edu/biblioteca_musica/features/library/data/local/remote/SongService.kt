package com.edu.biblioteca_musica.features.library.data.local.remote

import retrofit2.Response
import retrofit2.http.GET

interface SongService {

    @GET("chart/0/tracks")
    suspend fun getSongs(): Response<List<SongApiModel>>
}