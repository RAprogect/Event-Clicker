package com.raproject.eventclicker.di

import com.raproject.eventclicker.model.EventModel
import com.raproject.eventclicker.tools.EventFactory
import org.koin.dsl.module

var toolsModule = module {
    single { EventFactory() }
}
