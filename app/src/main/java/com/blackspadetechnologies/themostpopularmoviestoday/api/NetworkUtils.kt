package com.blackspadetechnologies.themostpopularmoviestoday.api

//
//fun parseJsonMovieResults(jsonResult: JSONObject): ArrayList<Movie> {
//    val movieResults = jsonResult.getJSONArray("results")
//
//    val movieItemList = ArrayList<Movie>()
//
//    for (i in 0 until movieResults.length()){
//        val movieJson = movieResults.getJSONObject(i)
//        val id = movieJson.getInt("id")
//        val posterPath = movieJson.getString("poster_path")
//        val overview = movieJson.getString("overview")
//        val releaseDate = movieJson.getString("release_date")
//        val genreIds = movieJson.getJSONArray("genre_ids").getInt(0)
//        val title = movieJson.getString("title")
//        val popularity = movieJson.getDouble("popularity")
//        val voteAverage = movieJson.getDouble("vote_average")
//
//        val movieItem = Movie(id, posterPath, overview, releaseDate,
//            genreIds, title, popularity, voteAverage)
//        movieItemList.add(movieItem)
//    }
//    return movieItemList
//}

