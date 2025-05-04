package com.edu.biblioteca_musica.features.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.edu.biblioteca_musica.R
import com.edu.biblioteca_musica.databinding.FragmentHomeBinding
import com.edu.biblioteca_musica.features.home.album.presentation.adapter.AlbumAdapter
import com.edu.biblioteca_musica.features.home.artist.presentation.adapter.ArtistAdapter
import kotlin.getValue
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val artistAdapter = ArtistAdapter()
    private val artistViewModel: HomeViewModel by viewModel()

    private val albumAdapter = AlbumAdapter()
    private val albumViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    private fun setUpView(){
        binding.apply {
            homeToolbar.topAppBar.title = requireContext().getString(R.string.app_name)
            artistsList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            artistsList.adapter = artistAdapter
        }

        binding.apply {
            albumsList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            albumsList.adapter = albumAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        artistViewModel.fetchArtists()
        albumViewModel.fetchAlbums()
    }

    private fun setUpObserver() {
        val artistObserver = Observer<HomeViewModel.UiState> {
            it.artists?.let { artists ->
                artistAdapter.submitList(artists)
            }

            it.errorApp.let{}

            if (it.isLoading){
                Log.d("@dev", "Loading...")
            } else {
                Log.d("@dev", "Loaded")
            }
        }
        artistViewModel.uiState.observe(viewLifecycleOwner, artistObserver)

        val albumObserver = Observer<HomeViewModel.UiState> {
            it.albums?.let { albums ->
                albumAdapter.submitList(albums)
            }

            it.errorApp.let{}

            if (it.isLoading){
                Log.d("@dev", "Loading...")
            } else {
                Log.d("@dev", "Loaded")
            }
        }
        albumViewModel.uiState.observe(viewLifecycleOwner, albumObserver)
    }
}

