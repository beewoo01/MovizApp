package com.example.movizapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movizapp.retrofit.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase() {

    // DAO
    abstract val moviesDao : MovieDAO

    companion object {
        @Volatile
        private var INSTANCE: MoviesDB? = null

        fun getInstance(context: Context): MoviesDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDB::class.java,
                        name = "movies_db"
                    ).build()
                }

                INSTANCE = instance

                return instance
            }
        }

    }


}