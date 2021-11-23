package com.raproject.eventclicker.di

import com.raproject.eventclicker.model.Event
import com.raproject.eventclicker.model.EventModel
import com.raproject.eventclicker.view_model.EventViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModels = module {
    viewModel { EventViewModel() }
}
