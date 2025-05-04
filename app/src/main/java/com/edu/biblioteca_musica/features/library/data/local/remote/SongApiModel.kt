package com.edu.biblioteca_musica.features.library.data.local.remote

import com.google.gson.annotations.SerializedName

data class SongApiModel(

    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("artist") val artist: String

)