package com.example.gitprofiledesc.presentation.di.profile

import com.example.gitprofiledesc.MainScreen
import dagger.Subcomponent

@ProfileScope
@Subcomponent(modules = [ProfileModule::class])
interface ProfileSubComponent {

    fun inject(profileActitvity: MainScreen)

    @Subcomponent.Factory
    interface Factory{
        fun create():ProfileSubComponent
    }

}