package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.location

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class Location(
    val name: String,
    @PrimaryKey
    val id: Int,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)