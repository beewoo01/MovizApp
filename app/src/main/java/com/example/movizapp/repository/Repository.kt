package com.example.movizapp.repository

import com.example.movizapp.retrofit.Movie
import com.example.movizapp.retrofit.RetrofitInstance

class Repository {

    suspend fun getPopularMoviesFromOnlineApi() : List<Movie> {
        return RetrofitInstance.api.getPopularMovies().results
    }
}