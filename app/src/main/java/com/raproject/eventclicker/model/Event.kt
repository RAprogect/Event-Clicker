package com.raproject.eventclicker.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Event(
    val id: Long = 0L,
    val eventActionCount: Int = 0,
    val eventDate: LocalDate = LocalDate.now(),
    val eventName: String = "",
    val lastUpdateTime: LocalDateTime = eventDate.atStartOfDay(),
    val eventTypeKey:String = ActivityType.Activity.key
)
