package com.rahul.assesment_04_02_2023.Di.Component

import com.rahul.assesment_04_02_2023.Di.ActivityScope
import com.rahul.assesment_04_02_2023.Di.Module.ActivityModule
import com.rahul.assesment_04_02_2023.Ui.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}