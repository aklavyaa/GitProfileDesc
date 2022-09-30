package com.example.gitprofiledesc.presentation.di.following

import com.example.gitprofiledesc.presentation.following.FollowingActivity
import dagger.Subcomponent

@FollowingScope
@Subcomponent(modules = [FollowingModule::class])
interface FollowingSubComponent {
    fun inject(activity: FollowingActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():FollowingSubComponent
    }
}