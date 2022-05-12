package com.blackspadetechnologies.themostpopularmoviestoday.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.FragmentBrowseBinding

class BrowseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentBrowseBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_browse,
            container, false)

        binding.backButton4.setOnClickListener { v: View ->
            v.findNavController().navigate(BrowseFragmentDirections.actionBrowseFragmentToDashboardFragment())
        }

        return binding.root
    }
}