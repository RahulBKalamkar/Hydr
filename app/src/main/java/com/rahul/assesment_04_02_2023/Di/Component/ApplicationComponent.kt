package com.rahul.assesment_04_02_2023.Di.Component

import android.content.Context
import com.rahul.assesment_04_02_2023.Data.Api.NetworkService
import com.rahul.assesment_04_02_2023.Data.Repository.WindInformationRepository
import com.rahul.assesment_04_02_2023.Di.ApplicationContext
import com.rahul.assesment_04_02_2023.Di.Module.ApplicationModule
import com.rahul.assesment_04_02_2023.MyApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getWindInformationRepository(): WindInformationRepository

}