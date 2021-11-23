package com.raproject.eventclicker.tools

import com.raproject.eventclicker.model.ActivityType
import com.raproject.eventclicker.model.EventModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

object TestRepository : KoinComponent {

    private val modelFactory: EventFactory by inject()
    val eventList = MutableStateFlow(createTestList().toMutableList())

    private fun createTestList() = buildList {
        ActivityType.values().forEachIndexed { index, activityType ->
            add(modelFactory.createEventModelByParams(eventType = activityType, id = index.toLong()))
        }
    }
}
