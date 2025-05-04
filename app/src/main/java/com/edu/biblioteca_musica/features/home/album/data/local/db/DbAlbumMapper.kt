package com.edu.biblioteca_musica.features.home.album.data.local.db

import com.edu.biblioteca_musica.features.home.album.domain.Album

fun Album.toEntity(): AlbumEntity =
    AlbumEntity(
        id = this.id,
        title = this.title,
        cover = this.cover
    )

fun AlbumEntity.toDomain(): Album =
    Album(
        id = this.id,
        title = this.title,
        cover = this.cover
    )