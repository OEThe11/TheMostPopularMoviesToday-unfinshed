package com.blackspadetechnologies.themostpopularmoviestoday.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.FragmentCommunityTabBinding

class CommunityTabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCommunityTabBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_community_tab,
            container, false)

        binding.backButtonThree.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(CommunityTabFragmentDirections.actionCommunityTabFragmentToDashboardFragment())
        }

        return binding.root
    }
}