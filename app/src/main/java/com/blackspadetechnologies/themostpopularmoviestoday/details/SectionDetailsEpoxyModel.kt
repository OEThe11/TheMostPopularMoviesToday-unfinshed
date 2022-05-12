package com.blackspadetechnologies.themostpopularmoviestoday.details

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.epoxy.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.epoxy_model_section_details)
abstract class SectionDetailsEpoxyModel: EpoxyModelWithHolder<Holder2>() {
    @EpoxyAttribute
    lateinit var details: String

    override fun bind(holder: Holder2) {
        holder.detailView.text = details
    }
}
class Holder2 : KotlinEpoxyHolder() {
    val detailView by bind<TextView>(R.id.section_details)

}