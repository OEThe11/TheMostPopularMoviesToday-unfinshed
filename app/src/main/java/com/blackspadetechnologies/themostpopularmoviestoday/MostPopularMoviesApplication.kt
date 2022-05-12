package com.blackspadetechnologies.themostpopularmoviestoday

import android.app.Application
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieDatabase

class MostPopularMoviesApplication : Application() {
    companion object {
        lateinit var movieDatabase: MovieDatabase
    }

    override fun onCreate() {
        super.onCreate()
        movieDatabase = MovieDatabase.getDatabase(this)
    }
}