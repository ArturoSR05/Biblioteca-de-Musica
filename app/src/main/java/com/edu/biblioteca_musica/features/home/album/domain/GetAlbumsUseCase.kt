package com.edu.biblioteca_musica.features.home.album.domain

import org.koin.core.annotation.Single

@Single
class GetAlbumsUseCase(private val albumRepository: AlbumRepository) {

    suspend operator fun invoke(): List<Album> {
        return albumRepository.getAlbums()
    }
}