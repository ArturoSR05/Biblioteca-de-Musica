package com.edu.biblioteca_musica.features.home.album.data.remote.retrofit

import com.edu.biblioteca_musica.features.home.album.domain.Album

fun AlbumApiModel.toModel(): Album {
    return Album(
        id = this.id,
        title = this.title,
        cover = this.cover
    )
}