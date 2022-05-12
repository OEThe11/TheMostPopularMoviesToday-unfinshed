package com.blackspadetechnologies.themostpopularmoviestoday.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.blackspadetechnologies.themostpopularmoviestoday.Result


@Dao
interface MovieDao{
    @Query("SELECT * FROM movie_info ORDER BY vote_average DESC")
    fun getAllMovieFeeds(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg movie: MovieEntity)

    @Query("SELECT * FROM movie_info ORDER BY title DESC")
    suspend fun getFeedByZ(): List<MovieEntity>

    @Query("SELECT * FROM movie_info ORDER BY title ASC")
    suspend fun getFeedByA(): List<MovieEntity>

    @Query("SELECT * FROM movie_info ORDER BY release_date DESC")
    suspend fun getReleaseDate(): List<MovieEntity>

    @Query("SELECT * FROM movie_info ORDER BY popularity DESC")
    suspend fun getPopVote(): List<MovieEntity>

    @Query("SELECT * FROM movie_info WHERE id=:id")
    suspend fun getMovieById(id: Int): MovieEntity?
}