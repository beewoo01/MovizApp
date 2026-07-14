package com.example.movizapp.screens

import androidx.compose.runtime.Composable
import com.example.movizapp.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel) {
    val moviesList = viewModel.movies
    MovieList(movies = moviesList)
}