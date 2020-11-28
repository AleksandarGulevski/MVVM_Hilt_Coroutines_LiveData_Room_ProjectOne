package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.ui.characters.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.character.Character
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository.CharacterRepository
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.utils.Resource

class CharacterDetailViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _character = _id.switchMap { id ->
        repository.getCharacter(id)
    }
    val character: LiveData<Resource<Character>> = _character


    fun start(id: Int) {
        _id.value = id
    }

}
