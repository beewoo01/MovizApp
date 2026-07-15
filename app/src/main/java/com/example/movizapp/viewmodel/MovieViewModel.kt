package com.example.movizapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movizapp.repository.Repository
import com.example.movizapp.retrofit.Movie
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository) : ViewModel() {
    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set


    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set


    init {
        viewModelScope.launch {
            try {
                moviesFromApi = repository.getPopularMoviesFromOnlineApi()

                repository.insertMoviesIntoDB(moviesFromApi)

                movies = moviesFromApi



            } catch (e: Exception) {
                e.printStackTrace()

                moviesFromRoomDB = repository.getMoviesFromDB()

                movies = moviesFromRoomDB
            }
        }
    }

}