package com.raproject.eventclicker.model

import java.time.LocalDate
import java.time.LocalDateTime

data class EventModel(
    var id: Long = 0L,
    var eventActionCount: Int = 0,
    var eventDate: LocalDate = LocalDate.now(),
    var eventName: String = "",
    var lastUpdateTime: LocalDateTime = eventDate.atStartOfDay(),
    private var eventTypeKey:String =ActivityType.Activity.key
){
    var eventType:ActivityType
    set(value) {
        eventTypeKey = value.key
    }get() = ActivityType.getTypeByKey(eventTypeKey)
}
