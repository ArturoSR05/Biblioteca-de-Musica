package com.edu.biblioteca_musica.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.biblioteca_musica.features.home.album.domain.Album
import com.edu.biblioteca_musica.features.home.album.domain.GetAlbumsUseCase
import com.edu.biblioteca_musica.features.home.artist.domain.Artist
import com.edu.biblioteca_musica.features.home.artist.domain.GetArtistsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val getArtistsListUseCase: GetArtistsListUseCase,
    private val getAlbumsListUseCase: GetAlbumsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun fetchArtists() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val artists = getArtistsListUseCase.invoke()
            _uiState.postValue(UiState(artists = artists, errorApp = false))
        }
    }

    fun fetchAlbums(){
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val albums = getAlbumsListUseCase.invoke()
            _uiState.postValue(UiState(albums = albums, errorApp = false))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val artists: List<Artist>? = null,
        val albums: List<Album>? = null,
        val errorApp: Boolean = false
    )
}