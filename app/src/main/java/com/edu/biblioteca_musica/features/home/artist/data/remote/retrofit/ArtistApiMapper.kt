package com.edu.biblioteca_musica.features.home.artist.data.remote.retrofit

import com.edu.biblioteca_musica.features.home.artist.domain.Artist

fun ArtistApiModel.toModel(): Artist {
    return Artist(
        this.id,
        this.name,
        this.picture
    )
}