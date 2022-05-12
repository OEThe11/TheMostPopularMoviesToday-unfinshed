package com.blackspadetechnologies.themostpopularmoviestoday.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.blackspadetechnologies.themostpopularmoviestoday.Result
import com.blackspadetechnologies.themostpopularmoviestoday.api.ApiClient
import com.blackspadetechnologies.themostpopularmoviestoday.api.MovieNetworkObject
import com.blackspadetechnologies.themostpopularmoviestoday.api.NetworkingService
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieDao
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity
import com.blackspadetechnologies.themostpopularmoviestoday.mappers.MovieMapper
import retrofit2.Response


class MovieRepository(private val movieDao: MovieDao) {
    private val allFeeds: LiveData<List<MovieEntity>> = movieDao.getAllMovieFeeds()
    private val _feeds: MediatorLiveData<List<MovieEntity>> = MediatorLiveData()
        val feeds: LiveData<List<MovieEntity>>
            get() = _feeds


    init {
        _feeds.addSource(allFeeds) {
            _feeds.value= it
        }
    }


    suspend fun getPopInfoR(apiKey: String, language: String): List<MovieEntity>?{
        val request = MovieNetworkObject.apiClient.getPopInfo(apiKey, language)

        if (request.isSuccessful){
                val movieItems = request.body()!!.results.map {
                    MovieMapper.buildFrom(it)
                }
            movieDao.insertAll(*movieItems.toTypedArray())
            return movieItems
        }

        return null
    }


//    suspend fun fetchMovieFeeds() {
//        val response = MovieNetworkObject.moshiNetworkServices.getPopInfo()
//        val feeds = parseJsonMovieResults(JSONObject(response))
//        movieDao.insertAll(*feeds.toTypedArray())
//    }

//    suspend fun filterMovieFeeds(filter: Filter){
//        val selection = when(filter) {
//            Filter.ASCENDING -> movieDao.getFeedByA()
//            Filter.DESCENDING -> movieDao.getFeedByZ()
//            Filter.POP_VOTE -> movieDao.getPopVote()
//            Filter.RELEASE_DATE -> movieDao.getReleaseDate()
//        }
//        _feeds.postValue(selection)
//    }




}