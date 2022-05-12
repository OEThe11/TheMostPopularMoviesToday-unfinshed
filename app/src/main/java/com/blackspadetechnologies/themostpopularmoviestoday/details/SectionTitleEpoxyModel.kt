package com.blackspadetechnologies.themostpopularmoviestoday.details

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.epoxy.KotlinEpoxyHolder


@EpoxyModelClass(layout = R.layout.epoxy_model_section_title)
abstract class SectionTitleEpoxyModel : EpoxyModelWithHolder<Holder4>() {
    @EpoxyAttribute
    lateinit var mainTitle: String

    override fun bind(holder: Holder4) {
        holder.mainTitleView.text = mainTitle
    }

}
class Holder4 : KotlinEpoxyHolder(){
    val mainTitleView by bind<TextView>(R.id.movie_title)
}