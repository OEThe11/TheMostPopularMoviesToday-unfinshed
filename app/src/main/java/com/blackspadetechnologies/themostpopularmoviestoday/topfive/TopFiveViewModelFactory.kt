package com.blackspadetechnologies.themostpopularmoviestoday.topfive

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TopFiveViewModelFactory (val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopFiveViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TopFiveViewModel(application) as T
        }
        throw IllegalArgumentException("Unable to construct viewModel")
    }
}