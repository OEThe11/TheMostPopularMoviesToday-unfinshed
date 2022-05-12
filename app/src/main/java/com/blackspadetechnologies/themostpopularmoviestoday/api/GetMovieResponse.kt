package com.blackspadetechnologies.themostpopularmoviestoday

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


data class GetMovieResponse(
    val results: List<Result> = emptyList()
)


data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int> = listOf(),
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)