package com.edu.biblioteca_musica.features.home.artist.domain

import org.koin.core.annotation.Single

@Single
class GetArtistsListUseCase(private val artistRepository: ArtistRepository) {

    suspend operator fun invoke(): List<Artist> {
        return artistRepository.getArtists()
    }
}