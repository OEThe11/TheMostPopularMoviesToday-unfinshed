package com.blackspadetechnologies.themostpopularmoviestoday.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.blackspadetechnologies.themostpopularmoviestoday.Result


@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(GenreConverter::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao

    companion object{
        private lateinit var INSTANCE: MovieDatabase

        fun getDatabase(context: Context): MovieDatabase{
            synchronized(MovieDatabase::class.java){
                if (!Companion::INSTANCE.isInitialized){
                   INSTANCE = Room.databaseBuilder(
                       context.applicationContext,
                       MovieDatabase::class.java,
                       "movie_info_1"
                   ).build()
                }
            }
            return INSTANCE
        }
    }
}