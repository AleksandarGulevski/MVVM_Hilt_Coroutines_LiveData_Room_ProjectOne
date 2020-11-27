package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local.EpisodeDao
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote.RemoteDataSource
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.utils.performGetOperation
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: EpisodeDao
) {

    fun getEpisode(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getEpisode(id) },
        networkCall = { remoteDataSource.getEpisode(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getEpisodes() = performGetOperation(
        databaseQuery = { localDataSource.getAllEpisodes() },
        networkCall = { remoteDataSource.getEpisodes() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}