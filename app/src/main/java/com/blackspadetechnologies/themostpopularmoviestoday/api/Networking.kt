package com.blackspadetechnologies.themostpopularmoviestoday.api

import com.blackspadetechnologies.themostpopularmoviestoday.Constants.BASE_URL
import com.blackspadetechnologies.themostpopularmoviestoday.GetMovieResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



interface NetworkingService {
    @GET(Endpoints.POPULAR)
    suspend fun getPopInfo(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Response<GetMovieResponse>
}


object MovieNetworkObject {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val networkingService: NetworkingService by lazy {
        retrofit.create(NetworkingService::class.java)
    }
    val apiClient = ApiClient(networkingService)

}

