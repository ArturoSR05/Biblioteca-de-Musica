package com.edu.biblioteca_musica.features.home.artist.data.remote.retrofit

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

data class ApiResponse<T>(
   @SerializedName("data") val data: List<T>
)

interface ArtistService {

    @GET("genre/197/artists")
    suspend fun getArtists(): Response<ApiResponse<ArtistApiModel>>

}