package com.blackspadetechnologies.themostpopularmoviestoday.details

import android.widget.ImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.displayImage
import com.blackspadetechnologies.themostpopularmoviestoday.epoxy.KotlinEpoxyHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@EpoxyModelClass(layout = R.layout.epoxy_model_image_view)
abstract class ImageViewEpoxyModel : EpoxyModelWithHolder<Holder3>() {
    @EpoxyAttribute
    lateinit var image: String

    override fun bind(holder: Holder3) {
        Glide.with(holder.imageView.context).load("https://image.tmdb.org/t/p/w500$image")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imageView)
    }
}

class Holder3 : KotlinEpoxyHolder(){
    val imageView by bind<ImageView>(R.id.poster_view)
}