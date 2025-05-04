package com.edu.biblioteca_musica.features.library.data.local.remote

import com.edu.biblioteca_musica.features.library.domain.Song

fun SongApiModel.toModel(): Song {
    return Song(
        this.id,
        this.title
    )
}