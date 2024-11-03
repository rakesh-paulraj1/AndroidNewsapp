package com.rakeshp.newsapp.domain.usecases.app_entry

import com.rakeshp.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun  invoke(){
        localUserManager.saveAppEntry()
    }
}