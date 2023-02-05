package com.rahul.assesment_04_02_2023.Di.Module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rahul.assesment_04_02_2023.Data.Repository.WindInformationRepository
import com.rahul.assesment_04_02_2023.Di.ActivityContext
import com.rahul.assesment_04_02_2023.Ui.Adapter.WindInfoAdapter
import com.rahul.assesment_04_02_2023.Ui.Base.ViewModelProviderFactory
import com.rahul.assesment_04_02_2023.Ui.WindInfo.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: WindInformationRepository): MainViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(MainViewModel::class) {
                MainViewModel(topHeadlineRepository)
            })[MainViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = WindInfoAdapter(ArrayList())

}