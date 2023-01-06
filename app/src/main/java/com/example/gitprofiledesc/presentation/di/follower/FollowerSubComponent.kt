package com.example.gitprofiledesc.presentation.di.follower

import com.example.gitprofiledesc.FollowersScreen
import dagger.Subcomponent

@FollowerScope
@Subcomponent(
    modules = [FollowerModule::class]
)
interface FollowerSubComponent {
    fun inject(activity: FollowersScreen)

    @Subcomponent.Factory
    interface Factory{
        fun create():FollowerSubComponent
    }


}