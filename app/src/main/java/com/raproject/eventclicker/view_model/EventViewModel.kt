package com.raproject.eventclicker.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raproject.eventclicker.model.Event
import com.raproject.eventclicker.tools.EventFactory
import com.raproject.eventclicker.tools.TestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class EventViewModel : ViewModel(), KoinComponent {

    private val modelFactory: EventFactory by inject()
    val eventsList = MutableStateFlow<List<Event>>(listOf())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            TestRepository.eventList.collect {
                eventsList.emit(modelFactory.covertEventModelListToEventsList(it))
            }
        }
    }
}
