package com.blackspadetechnologies.themostpopularmoviestoday.topfive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.Result
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.FragmentTopFiveBinding
import kotlin.math.abs

class TopFiveFragment : Fragment() {

    private lateinit var viewModel: TopFiveViewModel
    private lateinit var viewPager: ViewPager2

    var data: MutableList<MovieEntity> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTopFiveBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_top_five,
            container, false)

        val topViewModelFactory = TopFiveViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, topViewModelFactory).get(TopFiveViewModel::class.java)

        viewPager = binding.top5ViewPager

        val adapter = TopFiveAdapter(data, viewPager, onClick = { selectedMovieId ->
            val directions = TopFiveFragmentDirections.actionTopFiveFragmentToDetailFragment(selectedMovieId)
            findNavController().navigate(directions)
        })

        viewPager.adapter = adapter

        viewModel.topFiveInfo.observe(viewLifecycleOwner, Observer {
          adapter.addAll(it as MutableList<MovieEntity>)
        })

        binding.backButtonOne.setOnClickListener { v: View ->
            v.findNavController().navigate(TopFiveFragmentDirections.actionTopFiveFragmentToDashboardFragment())
        }


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