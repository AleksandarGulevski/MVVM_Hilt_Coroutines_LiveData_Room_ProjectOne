package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.episode

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.Info

data class EpisodeList (
    val info: Info,
    val results: List<Episode>
)