package com.example.movizapp.repository

import android.content.Context
import com.example.movizapp.retrofit.Movie
import com.example.movizapp.retrofit.RetrofitInstance
import com.example.movizapp.room.MovieDAO
import com.example.movizapp.room.MoviesDB

class Repository(context: Context) {

    suspend fun getPopularMoviesFromOnlineApi(): List<Movie> {
        return RetrofitInstance.api.getPopularMovies().results
    }

    private val db = MoviesDB.getInstance(context = context)
    private val movieDao: MovieDAO = db.moviesDao

    suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMoviesInDB()
    }

    suspend fun insertMoviesIntoDB(movies: List<Movie>) {
        return movieDao.insertMoviesList(movies)
    }

    suspend fun insertMovieIntoDB(movie: Movie) {
        return movieDao.insert(movie)
    }

}