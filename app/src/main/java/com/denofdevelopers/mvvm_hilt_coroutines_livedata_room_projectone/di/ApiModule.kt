package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.di

import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.BuildConfig
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote.ApiService
import com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.data.remote.RemoteDataSource
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideBaseHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(60, TimeUnit.SECONDS)
//        builder.addInterceptor(interceptor)
        builder.retryOnConnectionFailure(true)
//        if (BuildConfig.DEBUG) {
//            val logging = HttpLoggingInterceptor()
//            logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }
//            builder.addInterceptor(logging)
//        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource{
        return RemoteDataSource(apiService)
    }
}