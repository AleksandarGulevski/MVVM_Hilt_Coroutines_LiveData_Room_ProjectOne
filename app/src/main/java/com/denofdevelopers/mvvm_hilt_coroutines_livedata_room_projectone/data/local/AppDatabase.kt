package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.character.Character
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.episode.Episode
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.entities.location.Location
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.utils.ListConverter

@Database(entities = [Character::class, Episode::class, Location::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "rickandmorty")
                .fallbackToDestructiveMigration()
                .build()
    }
}