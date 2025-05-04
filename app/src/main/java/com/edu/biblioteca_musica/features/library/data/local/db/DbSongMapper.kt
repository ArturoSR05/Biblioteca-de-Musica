package com.edu.biblioteca_musica.features.library.data.local.db

import com.edu.biblioteca_musica.features.library.domain.Song

fun Song.toEntity(): SongEntity =
    SongEntity(
        id = this.id,
        title = this.title
    )

fun SongEntity.toDomain(): Song =
    Song(
        id = this.id,
        title = this.title
    )