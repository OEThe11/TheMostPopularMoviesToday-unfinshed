package com.blackspadetechnologies.themostpopularmoviestoday.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.FragmentDashboardBinding
import kotlin.math.abs

class DashboardFragment : Fragment(){

    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDashboardBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dashboard,
            container, false)

        viewPager = binding.viewPager

        val categories: MutableList<DashboardElements> = ArrayList()
        categories.add(DashboardElements.DETwo(100, R.drawable.darkbackground, R.string.direction_title,R.string.menu_directions))
        categories.add(DashboardElements.DEOne(101, R.drawable.top_5_pic_8, R.string.top_five_title, R.string.top_five_desc))
        categories.add(DashboardElements.DEOne(102, R.drawable.mainp1, R.string.genre_title_string, R.string.genre_desc))
        categories.add(DashboardElements.DEOne(103, R.drawable.mainp2, R.string.browse_title, R.string.browse_desc))
        categories.add(DashboardElements.DEOne(104, R.drawable.mainp3, R.string.fourth_title, R.string.community_desc))

        viewPager.adapter = DashboardAdapter(categories, viewPager)

        //The Animation Component
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.25f
        }

        viewPager.setPageTransformer(compositePageTransformer)

        return binding.root
    }
}