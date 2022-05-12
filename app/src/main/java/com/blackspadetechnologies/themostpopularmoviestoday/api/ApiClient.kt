package com.blackspadetechnologies.themostpopularmoviestoday.api


import com.blackspadetechnologies.themostpopularmoviestoday.GetMovieResponse
import retrofit2.Response

class ApiClient (
    private val moshiNetworkService: NetworkingService
        ) {

        suspend fun getPopInfo(apiKey: String, language: String): Response<GetMovieResponse>{
            return moshiNetworkService.getPopInfo(apiKey, language)
        }
}
