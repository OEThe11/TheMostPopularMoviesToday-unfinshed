package com.blackspadetechnologies.themostpopularmoviestoday.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blackspadetechnologies.themostpopularmoviestoday.MostPopularMoviesApplication
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val repository = DetailsRepository(MostPopularMoviesApplication.movieDatabase.movieDao)

    private val _selectedMovieEntityLiveData = MutableLiveData<MovieEntity>()
    val selectedMovieEntityLiveData : LiveData<MovieEntity> = _selectedMovieEntityLiveData

    fun fetchMovieById(id: Int) {
        viewModelScope.launch {
           val fetchMovieEntity =  repository.fetchMovieById(id)
            _selectedMovieEntityLiveData.postValue(fetchMovieEntity)
        }
    }
}