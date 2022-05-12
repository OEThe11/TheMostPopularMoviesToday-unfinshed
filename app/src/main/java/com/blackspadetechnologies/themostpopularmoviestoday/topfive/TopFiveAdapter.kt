package com.blackspadetechnologies.themostpopularmoviestoday.topfive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.blackspadetechnologies.themostpopularmoviestoday.Result
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.ContainerTopFiveBinding

class TopFiveAdapter (var topInfo: MutableList<MovieEntity>, val viewPager2: ViewPager2, val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<TopFiveAdapter.TopFiveViewHolder>() {

    init {
        topInfo
        viewPager2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFiveViewHolder {
        return TopFiveViewHolder(ContainerTopFiveBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TopFiveViewHolder, position: Int) {
        holder.bind(topInfo[position], onClick = onClick)
    }

    override fun getItemCount(): Int {
        val limit = 5
        return if (topInfo.size > limit){
            limit
        } else{
            topInfo.size
        }
    }

    class TopFiveViewHolder(private val binding: ContainerTopFiveBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(items: MovieEntity, onClick: (Int) -> Unit) {
            binding.tp = items
            binding.t5Poster.setOnClickListener {
               onClick(items.id)
            }
            binding.executePendingBindings()
        }
    }

    fun addAll (items: MutableList<MovieEntity>){
        topInfo = items
        notifyDataSetChanged()
    }
}