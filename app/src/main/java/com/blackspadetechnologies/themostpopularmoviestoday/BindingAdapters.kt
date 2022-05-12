package com.blackspadetechnologies.themostpopularmoviestoday

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("posterImage")
fun ImageView.displayImage(url: String){
   Glide.with(context).load("https://image.tmdb.org/t/p/w500$url")
       .diskCacheStrategy(DiskCacheStrategy.ALL)
       .into(this)
}


@BindingAdapter("starRating")
fun ImageView.ratingImage(ratedScore: Double){
    when {
        ratedScore >= 9.0 -> {
            setImageResource(R.drawable.star_rating_5)
        }
        ratedScore in 7.0..8.9 -> {
            setImageResource(R.drawable.star_rating_4)
        }
        ratedScore in 5.0..6.9 -> {
            setImageResource(R.drawable.star_rating_3)
        }
        ratedScore in 3.0..4.9 -> {
            setImageResource(R.drawable.star_rating_2)
        }
        else -> {
            setImageResource(R.drawable.star_rating_1)
        }
    }
}