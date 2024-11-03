package com.rakeshp.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.flowOf
interface LocalUserManager {

    suspend fun saveAppEntry()

    fun ReadAppEntry(): Flow<Boolean>
}