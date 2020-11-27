package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local.CharacterDao
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote.RemoteDataSource
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.utils.performGetOperation
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: CharacterDao
) {

    fun getCharacter(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getCharacter(id) },
        networkCall = { remoteDataSource.getCharacter(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}