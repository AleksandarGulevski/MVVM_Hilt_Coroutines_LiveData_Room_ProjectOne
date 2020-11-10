package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.application

import android.app.Application
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.BuildConfig
import com.devs.acr.AutoErrorReporter
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initCrashLibrary()
        initTimber()
    }

    private fun initCrashLibrary() {
        if (BuildConfig.DEBUG) {
            AutoErrorReporter.get(this)
                .setEmailAddresses(BuildConfig.EMAIL)
                .setEmailSubject(BuildConfig.EMAIL_SUBJECT)
                .start()
        } else {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initTimber(){
        Timber.plant(Timber.DebugTree())
    }

}