package com.blackspadetechnologies.themostpopularmoviestoday.topfive

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.blackspadetechnologies.themostpopularmoviestoday.Constants.API_KEY
import com.blackspadetechnologies.themostpopularmoviestoday.Constants.LANGUAGE
import com.blackspadetechnologies.themostpopularmoviestoday.Result
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieDatabase
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity
import com.blackspadetechnologies.themostpopularmoviestoday.repository.MovieRepository
import kotlinx.coroutines.launch

private const val TAG = "TopFiveViewModel"

class TopFiveViewModel(application: Application) : ViewModel() {
    private val database = MovieDatabase.getDatabase(application)

    private val repository = MovieRepository(database.movieDao)

    private val _topFive = MutableLiveData<MovieEntity>()
    val topFive: LiveData<MovieEntity>
    get() = _topFive

    val topFiveInfo: LiveData<List<MovieEntity>> = Transformations.map(repository.feeds) {
        it
    }


    init {
        loadTopFiveFeed()

    }



    private fun loadTopFiveFeed() {
        viewModelScope.launch {
            try {
                repository.getPopInfoR(API_KEY, LANGUAGE)
            }catch (e: Exception){
                Log.e(TAG, e.message, e.cause)
            }
        }

    }
}