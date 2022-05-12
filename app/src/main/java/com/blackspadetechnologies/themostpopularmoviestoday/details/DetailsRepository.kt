package com.blackspadetechnologies.themostpopularmoviestoday.details

import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieDao
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity

class DetailsRepository(private val movieDao: MovieDao) {

    suspend fun fetchMovieById(id: Int) : MovieEntity? {
        return movieDao.getMovieById(id)
    }

}