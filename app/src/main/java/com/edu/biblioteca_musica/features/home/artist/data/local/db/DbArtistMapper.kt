package com.edu.biblioteca_musica.features.home.artist.data.local.db

import com.edu.biblioteca_musica.features.home.artist.domain.Artist

fun Artist.toEntity(): ArtistEntity =
    ArtistEntity(
        id = this.id,
        name = this.name,
        picture = this.picture
    )

fun ArtistEntity.toDomain(): Artist =
    Artist(
        id = this.id,
        name = this.name,
        picture = this.picture
    )