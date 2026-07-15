package com.example.movizapp.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    /*@SerializedName("release_date")
    val release_date: String,
    val softcore: Boolean,
    val video: Boolean,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("vote_count")
    val voteCount: Int*/
)
