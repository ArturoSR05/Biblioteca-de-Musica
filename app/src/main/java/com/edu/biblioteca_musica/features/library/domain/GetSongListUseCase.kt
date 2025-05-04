package com.edu.biblioteca_musica.features.library.domain

class GetSongListUseCase(private val songRepository: SongRepository) {

    suspend operator fun invoke(): List<Song> {
        return songRepository.getSongs()
    }
}