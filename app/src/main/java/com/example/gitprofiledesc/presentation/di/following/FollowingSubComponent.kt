package com.example.gitprofiledesc.presentation.di.following

import com.example.gitprofiledesc.FollowingScreen
import dagger.Subcomponent

@FollowingScope
@Subcomponent(modules = [FollowingModule::class])
interface FollowingSubComponent {
    fun inject(activity: FollowingScreen)

    @Subcomponent.Factory
    interface Factory{
        fun create():FollowingSubComponent
    }
}