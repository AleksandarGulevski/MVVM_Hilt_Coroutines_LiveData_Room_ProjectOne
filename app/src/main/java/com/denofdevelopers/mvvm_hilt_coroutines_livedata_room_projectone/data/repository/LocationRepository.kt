package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local.LocationDao
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote.RemoteDataSource
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.utils.performGetOperation
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocationDao
) {

    fun getLocation(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getLocation(id) },
        networkCall = { remoteDataSource.getLocation(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getLocations() = performGetOperation(
        databaseQuery = { localDataSource.getAllLocations() },
        networkCall = { remoteDataSource.getLocations() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}