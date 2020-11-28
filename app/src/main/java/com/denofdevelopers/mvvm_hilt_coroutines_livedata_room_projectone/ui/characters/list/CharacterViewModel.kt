package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.ui.characters.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository.CharacterRepository

class CharacterViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
): ViewModel() {

    val characters = repository.getCharacters()
}