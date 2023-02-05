package com.rahul.assesment_04_02_2023

import android.app.Application
import com.rahul.assesment_04_02_2023.Di.Component.ApplicationComponent
import com.rahul.assesment_04_02_2023.Di.Component.DaggerApplicationComponent
import com.rahul.assesment_04_02_2023.Di.Module.ApplicationModule

class MyApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}