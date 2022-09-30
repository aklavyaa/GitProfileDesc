package com.example.gitprofiledesc.presentation.di.follower

import com.example.gitprofiledesc.presentation.followers.FollowerActivity
import dagger.Subcomponent

@FollowerScope
@Subcomponent(
    modules = [FollowerModule::class]
)
interface FollowerSubComponent {
    fun inject(activity: FollowerActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():FollowerSubComponent
    }


}