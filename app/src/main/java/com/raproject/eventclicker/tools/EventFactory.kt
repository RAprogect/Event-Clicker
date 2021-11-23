package com.raproject.eventclicker.tools

import com.raproject.eventclicker.model.ActivityType
import com.raproject.eventclicker.model.Event
import com.raproject.eventclicker.model.EventModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import java.time.LocalDate
import java.time.LocalDateTime

class EventFactory : KoinComponent {

    fun createEventModelByParams(
        id: Long? =null,
        eventActionCount: Int? = null,
        eventDate: LocalDate? = null,
        eventName: String? = "",
        eventType:ActivityType? = null
    ): EventModel {
        val event: EventModel by inject ()
        id?.let { event.id = id }
        eventActionCount?.let { event.eventActionCount = it }
        eventDate?.let { event.eventDate = it }
        eventName?.let { event.eventName = it }
        eventType?.let { event.eventType = eventType }
        return event
    }

    fun covertEventModelListToEventsList(eventModelList: MutableList<EventModel>): List<Event> {
        return eventModelList.map { convertEventModelToEvent(it) }
    }

    private fun convertEventModelToEvent(eventModel: EventModel): Event {
        val event: Event by inject { parametersOf(eventModel) }
        return event
    }
}
