package com.rahul.assesment_04_02_2023.Di.Module

import android.content.Context
import com.rahul.assesment_04_02_2023.Data.Api.NetworkService
import com.rahul.assesment_04_02_2023.Di.ApplicationContext
import com.rahul.assesment_04_02_2023.Di.BaseUrl
import com.rahul.assesment_04_02_2023.MyApplication
import com.rahul.assesment_04_02_2023.Utils.AppConstant.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = BASE_URL

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }

}