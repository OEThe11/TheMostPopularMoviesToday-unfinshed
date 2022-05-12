package com.blackspadetechnologies.themostpopularmoviestoday.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.FragmentGenreBinding

class GenreFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGenreBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_genre,
            container, false)

        binding.backButtonTwo.setOnClickListener { v: View ->
            v.findNavController().navigate(GenreFragmentDirections.actionGenreFragmentToDashboardFragment())
        }

        return binding.root
    }
}