package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.R

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<TextView>(R.id.charactersButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeScreen_to_charactersScreen)
        }

        view.findViewById<TextView>(R.id.episodesButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeScreen_to_episodesScreen)
        }

        view.findViewById<TextView>(R.id.locationsButton).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeScreen_to_locationsScreen)
        }

        return view
    }
}