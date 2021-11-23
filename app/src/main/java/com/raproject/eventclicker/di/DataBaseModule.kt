package com.raproject.eventclicker.di

import com.raproject.eventclicker.model.Event
import com.raproject.eventclicker.model.EventModel
import org.koin.dsl.module

var modelsFactoryModule = module {
    factory { EventModel() }
    factory { (param:EventModel?) -> when(param){
            null ->Event()
            else -> Event(
                id = param.id,
                eventTypeKey = param.eventType.key,
                eventDate = param.eventDate,
                eventName = param.eventName,
                lastUpdateTime = param.lastUpdateTime,
                eventActionCount = param.eventActionCount
            )
        }
    }
}
