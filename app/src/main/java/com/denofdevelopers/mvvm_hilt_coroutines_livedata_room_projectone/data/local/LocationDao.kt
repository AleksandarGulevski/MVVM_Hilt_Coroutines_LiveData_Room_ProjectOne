package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.location.Location

@Dao
interface LocationDao {

    @Query("SELECT * FROM locations")
    fun getAllLocations() : LiveData<List<Location>>

    @Query("SELECT * FROM locations WHERE id = :id")
    fun getLocation(id: Int): LiveData<Location>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(locations: List<Location>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(location: Location)
}