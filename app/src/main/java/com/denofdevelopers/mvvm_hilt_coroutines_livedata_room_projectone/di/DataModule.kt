package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.di

import android.content.Context
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local.AppDatabase
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local.CharacterDao
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local.EpisodeDao
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.local.LocationDao
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote.RemoteDataSource
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository.CharacterRepository
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository.EpisodeRepository
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.repository.LocationRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase) = db.characterDao()

    @Singleton
    @Provides
    fun provideCharacterRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: CharacterDao
    ): CharacterRepository {
        return CharacterRepository(remoteDataSource, localDataSource)
    }

    @Singleton
    @Provides
    fun provideEpisodeRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: EpisodeDao
    ): EpisodeRepository {
        return EpisodeRepository(remoteDataSource, localDataSource)
    }

    @Singleton
    @Provides
    fun provideLocationRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocationDao
    ): LocationRepository {
        return LocationRepository(remoteDataSource, localDataSource)
    }
}