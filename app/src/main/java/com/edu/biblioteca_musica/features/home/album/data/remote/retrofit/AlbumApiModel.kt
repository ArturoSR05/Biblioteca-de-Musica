package com.edu.biblioteca_musica.features.home.album.data.remote.retrofit

import com.google.gson.annotations.SerializedName

data class AlbumApiModel (

    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("cover") val cover: String

)

