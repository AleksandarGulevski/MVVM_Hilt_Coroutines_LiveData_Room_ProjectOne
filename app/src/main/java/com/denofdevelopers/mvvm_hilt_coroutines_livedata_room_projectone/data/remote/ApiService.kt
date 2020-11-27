package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.character.Character
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.character.CharacterList
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.episode.Episode
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.episode.EpisodeList
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.location.Location
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.location.LocationList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<EpisodeList>

    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Response<Episode>

    @GET("location")
    suspend fun getAllLocations(): Response<LocationList>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Response<Location>
}