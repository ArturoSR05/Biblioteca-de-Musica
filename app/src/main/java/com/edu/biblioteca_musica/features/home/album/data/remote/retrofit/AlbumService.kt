package com.edu.biblioteca_musica.features.home.album.data.remote.retrofit

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

data class AlbumResponse(
    @SerializedName("data") val albums: List<AlbumApiModel>
)

interface AlbumService {

    @GET("chart/0/albums")
    suspend fun getAlbums(): Response<AlbumResponse>
}