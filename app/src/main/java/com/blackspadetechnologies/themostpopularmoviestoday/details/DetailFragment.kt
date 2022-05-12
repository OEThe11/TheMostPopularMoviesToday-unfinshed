package com.blackspadetechnologies.themostpopularmoviestoday.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.airbnb.epoxy.EpoxyRecyclerView
import com.blackspadetechnologies.themostpopularmoviestoday.R
import com.blackspadetechnologies.themostpopularmoviestoday.database.MovieEntity
import com.blackspadetechnologies.themostpopularmoviestoday.databinding.FragmentDetailsBinding

class DetailFragment : Fragment(R.layout.fragment_details) {
    private val viewModel : DetailViewModel by viewModels()
    private val safeArgs : DetailFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val epoxyRecyclerView : EpoxyRecyclerView = view.findViewById(R.id.epoxy_recycler_view)
        val detailsEpoxyController = DetailsEpoxyController()
        epoxyRecyclerView.setController(detailsEpoxyController)


        viewModel.selectedMovieEntityLiveData.observe(viewLifecycleOwner, Observer {
            detailsEpoxyController.info = it
            detailsEpoxyController.requestModelBuild()
        })

        viewModel.fetchMovieById(safeArgs.selectedMovieId)


    }
}