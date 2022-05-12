package com.blackspadetechnologies.themostpopularmoviestoday.dashboard

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


sealed class DashboardElements {
    class DEOne(val id: Int,
                val image: Int,
                val category: Int,
                val description: Int): DashboardElements()

    class DETwo(val id: Int,
                val image: Int,
                val category: Int,
                val description: Int): DashboardElements()
}