package com.blackspadetechnologies.themostpopularmoviestoday.details

import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.epoxy.KotlinEpoxyHolder


@EpoxyModelClass(layout = R.layout.epoxy_model_section_header)
abstract class SectionHeaderEpoxyModel: EpoxyModelWithHolder<Holder>() {
    @EpoxyAttribute
    lateinit var title: String

    override fun bind(holder: Holder) {
        holder.titleView.text = title
    }
}
class Holder : KotlinEpoxyHolder() {
    val titleView by bind<TextView>(R.id.header_text_view)

}