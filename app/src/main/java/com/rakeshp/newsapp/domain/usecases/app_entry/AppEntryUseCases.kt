package com.rakeshp.newsapp.domain.usecases.app_entry

import com.rakeshp.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.rakeshp.newsapp.domain.usecases.app_entry.SaveAppEntry

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)
