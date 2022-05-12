package com.blackspadetechnologies.themostpopularmoviestoday.dashboard

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.ContainerDashboardOneBinding
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.ContainerFirstSlideBinding

sealed class DashboardViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class DashboardViewHolderOne(private val binding: ContainerDashboardOneBinding) : DashboardViewHolder(binding){
        fun bind(item: DashboardElements.DEOne){
            binding.dash = item
            binding.executePendingBindings()

            when (adapterPosition) {
                1 -> {
                    binding.root.setOnClickListener { v: View ->
                        v.findNavController()
                            .navigate(DashboardFragmentDirections.actionDashboardFragmentToTopFiveFragment())
                    }
                }
                2 -> {
                    binding.root.setOnClickListener { v: View ->
                        v.findNavController()
                            .navigate(DashboardFragmentDirections.actionDashboardFragmentToGenreFragment())
                    }
                }
                3 -> {
                    binding.root.setOnClickListener { v: View ->
                        v.findNavController()
                            .navigate(DashboardFragmentDirections.actionDashboardFragmentToBrowseFragment())
                    }
                }
                4 -> {
                    binding.root.setOnClickListener { v: View ->
                        v.findNavController()
                            .navigate(DashboardFragmentDirections.actionDashboardFragmentToCommunityTabFragment())
                    }
                }
            }


        }

    }

    class DashboardViewHolderTwo(private val binding: ContainerFirstSlideBinding) : DashboardViewHolder(binding){
        fun bind(items: DashboardElements.DETwo){
            binding.dash2 = items
            binding.executePendingBindings()
        }
    }

}