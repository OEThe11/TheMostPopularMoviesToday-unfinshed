package com.blackspadetechnologies.themostpopularmoviestoday.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.ContainerDashboardOneBinding
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.ContainerFirstSlideBinding
import java.lang.IllegalArgumentException

class DashboardAdapter(val dash: MutableList<DashboardElements>, private val viewpager2: ViewPager2) :
    RecyclerView.Adapter<DashboardViewHolder>() {


    init {
        dash
        viewpager2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return when(viewType){
            R.layout.container_dashboard_one -> DashboardViewHolder.DashboardViewHolderOne(
                ContainerDashboardOneBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )

            R.layout.container_first_slide -> DashboardViewHolder.DashboardViewHolderTwo(
                ContainerFirstSlideBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid ViewHolder")
        }
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        when(holder){
            is DashboardViewHolder.DashboardViewHolderOne -> holder.bind(dash[position] as DashboardElements.DEOne)
            is DashboardViewHolder.DashboardViewHolderTwo -> holder.bind(dash[position] as DashboardElements.DETwo)
        }
    }

    override fun getItemCount(): Int {
        return dash.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(dash[position]){
            is DashboardElements.DEOne -> R.layout.container_dashboard_one
            is DashboardElements.DETwo -> R.layout.container_first_slide
        }
    }



    }
