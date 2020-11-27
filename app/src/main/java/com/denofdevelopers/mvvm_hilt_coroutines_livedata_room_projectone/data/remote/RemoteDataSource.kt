package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
): BaseDataSource() {

    suspend fun getCharacters() = getResult { apiService.getAllCharacters() }
    suspend fun getCharacter(id: Int) = getResult { apiService.getCharacter(id) }

    suspend fun getEpisodes() = getResult { apiService.getAllEpisodes() }
    suspend fun getEpisode(id: Int) = getResult { apiService.getEpisode(id) }

    suspend fun getLocations() = getResult { apiService.getAllLocations() }
    suspend fun getLocation(id: Int) = getResult { apiService.getLocation(id) }
}