package com.example.movizapp.retrofit

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Accept : application/json",
        "Accept : application/json"
    )
    @GET("movie/popular")
    suspend fun getPopularMovies() : MovieResponse
}