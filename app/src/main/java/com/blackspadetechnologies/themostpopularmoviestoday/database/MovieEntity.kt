package com.blackspadetechnologies.themostpopularmoviestoday.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie_info")
data class MovieEntity (
    val backdrop_path: String,
    @PrimaryKey
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
    )