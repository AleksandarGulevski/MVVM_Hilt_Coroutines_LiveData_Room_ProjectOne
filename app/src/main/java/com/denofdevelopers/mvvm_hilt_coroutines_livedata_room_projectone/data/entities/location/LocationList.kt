package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.location

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.Info

data class LocationList (
    val info: Info,
    val results: List<Location>
)