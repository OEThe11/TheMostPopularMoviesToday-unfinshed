package com.blackspadetechnologies.themostpopularmoviestoday.mappers

import com.blackspadetechnologies.themostpopularmoviestoday.GetMovieResponse
import com.blackspadetechnologies.themostpopularmoviestoday.Result
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity


object MovieMapper{

    fun buildFrom(response: Result): MovieEntity{
        return MovieEntity(
            backdrop_path = response.backdrop_path,
            id = response.id,
            original_language = response.original_language,
            original_title = response.original_title,
            overview = response.overview,
            popularity = response.popularity,
            poster_path = response.poster_path,
            release_date = response.release_date,
            title = response.title,
            vote_average = response.vote_average,
            vote_count = response.vote_count
        )
    }

}