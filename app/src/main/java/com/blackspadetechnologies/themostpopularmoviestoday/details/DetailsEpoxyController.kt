package com.blackspadetechnologies.themostpopularmoviestoday.details

import com.airbnb.epoxy.EpoxyController
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity

class DetailsEpoxyController : EpoxyController() {
    var info : MovieEntity? = null

    override fun buildModels() {
        if(info == null){
            //at Loading State
            return
        }

        val mainTitle = "Main Title"
        SectionTitleEpoxyModel_().id(mainTitle).mainTitle(info!!.title).addTo(this)

        val overview = "Overview"
        SectionHeaderEpoxyModel_().id(overview).title(overview).addTo(this)
        SectionDetailsEpoxyModel_().id(info!!.overview).details(info!!.overview).addTo(this)

        val releaseDate = "Release Date"
        SectionHeaderEpoxyModel_().id(releaseDate).title(releaseDate).addTo(this)
        SectionDetailsEpoxyModel_().id(info!!.release_date).details(info!!.release_date).addTo(this)

        val imageView = "Image View"
        ImageViewEpoxyModel_().id(imageView).image(info!!.poster_path).addTo(this)
    }



}