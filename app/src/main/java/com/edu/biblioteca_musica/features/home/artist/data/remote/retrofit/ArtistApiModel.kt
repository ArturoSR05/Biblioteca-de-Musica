package com.edu.biblioteca_musica.features.home.artist.data.remote.retrofit

import com.google.gson.annotations.SerializedName

data class ArtistApiModel(

    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("picture") val picture: String
)