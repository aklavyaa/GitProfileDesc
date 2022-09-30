package com.example.gitprofiledesc.presentation.di.profile

import com.example.gitprofiledesc.presentation.profile.ProfileActitvity
import dagger.Subcomponent

@ProfileScope
@Subcomponent(modules = [ProfileModule::class])
interface ProfileSubComponent {

    fun inject(profileActitvity: ProfileActitvity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ProfileSubComponent
    }

}