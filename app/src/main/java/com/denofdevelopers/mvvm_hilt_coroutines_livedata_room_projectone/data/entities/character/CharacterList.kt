package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.character

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.Info

data class CharacterList (
    val info: Info,
    val results: List<Character>
)