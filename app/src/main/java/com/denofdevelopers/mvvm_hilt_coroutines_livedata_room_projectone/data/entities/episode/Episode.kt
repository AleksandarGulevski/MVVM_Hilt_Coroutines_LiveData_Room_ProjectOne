package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.episode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episodes")
data class Episode (
val name: String,
@PrimaryKey
val id: Int,
@SerializedName("air_date")
val airDate: String,
val episode: String,
val characters: List<String>,
val url: String,
val created: String
)